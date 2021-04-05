/**
 * Created by allen
 * All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 *
 */

package com.allen.dexcounter

import com.android.dex.Dex
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class DexCounterPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "apply plugin :dexCounter"
        project.extensions.create("dexCounterExt", DexCounterExtension)

        project.afterEvaluate {
            //统计dex方法数
            project.afterEvaluate {
                Task dexMergeDebug = project.tasks.findByName('transformDexArchiveWithDexMergerForDebug')
                boolean enable = project.extensions.dexCounterExt.enable
                if (dexMergeDebug != null && enable) {
                    dexMergeDebug.doLast {
                        List<Dex> dexList = new ArrayList<>()
                        dexMergeDebug.outputs.files.each { File f ->
                            println "dexMergeDebug outputs=${f.absolutePath}"
                            // dexMerger/debug/0/classes.dex classes2.dex
                            f.listFiles().each {
                                File subFile ->
                                    if (subFile.isDirectory()) {
                                        subFile.listFiles(new FilenameFilter() {
                                            @Override
                                            boolean accept(File dir, String name) {
                                                return name.endsWith(".dex")
                                            }
                                        }).each {
                                            File dexFile ->
                                                println "find dex file ${dexFile.absolutePath}"
                                                dexList.add(new Dex(dexFile))
                                        }
                                    }
                            }
                        }
                        //start count size
                        countDexMethodSize(dexList)
                    }
                }
            }
        }
    }

    static def countDexMethodSize(List<Dex> dexList,Project proj) {
        int sum = 0
        int max = proj.extensions.dexCounterExt.threshold
        dexList.each { Dex dex ->
            sum += dex.methodIds().size()
            println ">>>>>>>>>>>>dex nums=${dexList.size()} method size:${sum}>>>>>>>>>>>>>>>"
            if (sum > max) {
                throw new GradleException("dex size is more than ${max},please split dex to others plugins....")
            }
        }
    }
}
