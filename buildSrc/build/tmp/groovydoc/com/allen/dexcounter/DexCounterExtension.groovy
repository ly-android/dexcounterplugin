package com.allen.dexcounter

/**
 * Create On 27/10/2020
 * @author liyong1
 */
class DexCounterExtension {
    int threshold
    boolean enable

    DexCounterExtension() {
        threshold = 60000
        enable = true
    }

    @Override
    String toString() {
        return "DexCounterExtension{" +
                "threshold='" + threshold + '\'' +
                ", enable=" + enable +
                '}'
    }
}
