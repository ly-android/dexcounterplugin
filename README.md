[ ![Download](https://api.bintray.com/packages/allenli/tinypngplugin/tinyPng/images/download.svg?version=1.0.0) ](https://bintray.com/allenli/tinypngplugin/tinyPng/1.0.0/link)

### dexCounterPlugin
`TinyPngPlugin` is a Gradle plugin for [TinyPng](https://tinypng.com/), can batch optimize your images.

### Get Tiny API key
Before use this plugin, you need get a Tiny API Key first. Goto [Tiny Developers Page](https://tinypng.com/developers), input your email and name to get the key.

*Notice: The first 500 compressions each month are free. You will only be billed if you compress more than 500 images.*

### Getting Started
Add `dexCounterPlugin` as a dependency in your main build.gradle in the root of your project:

 	dependencies {
    	classpath 'com.allen.tools.gradle:dexCounter:1.0.0'
	}

Then you need to apply the plugin and configure your `tinyinfo` by adding the following lines to your `app/build.gradle`:

 	apply plugin: 'dexCounter'

 	dexCounterExt {
        enable = true
        threshold = 1000
    }

### Licence
MIT License

Copyright (c) 2016 Wayne Yang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
