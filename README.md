Weaver Demo
==========

Basic example of java.lang.instrument and AspectJ Weaver.

Demo Instrument
---------------

This is a trivial example of the java.lang.instrument package.

Sample output:

    mvn clean package exec:exec -Pdemo-instrument

    0 [main] INFO example.instrument.MyJavaAgent - in premain()
    16 [main] INFO example.instrument.MyClassFileTransformer - Got to MyClassFileTransformer.transform()
    16 [main] INFO example.instrument.MyClassFileTransformer - Class Name: example/instrument/MyMainClass
    16 [main] INFO example.instrument.MyClassFileTransformer - Class: null
    16 [main] INFO example.instrument.MyClassFileTransformer - ************ RAW CLASS BYTES ************
    16 [main] INFO example.instrument.MyClassFileTransformer - ffffffcafffffffeffffffbaffffffbe0003103fa01002790a0287029a03027802aa0302ba0302ca0302d90a02e702f8030a0a031a0a02db032033a03403570361036c6f6710124c6f72672f736c66346a2f4c6f676765723b1046461746110124c6a6176612f6c616e672f537472696e673b1063c696e69743e1015284c6a6176612f6c616e672f537472696e673b2956104436f646510f4c696e654e756d6265725461626c6510124c6f63616c5661726961626c655461626c651047468697310204c6578616d706c652f696e737472756d656e742f4d794d61696e436c6173733b10767657444617461101428294c6a6176612f6c616e672f537472696e673b108746f537472696e671046d61696e1016285b4c6a6176612f6c616e672f537472696e673b29561046172677310135b4c6a6176612f6c616e672f537472696e673b1083c636c696e69743e10328295610a536f7572636546696c6510104d794d61696e436c6173732e6a617661c015024c01301410176a6176612f6c616e672f537472696e674275696c64657210124d794d61696e436c6173737b646174613d27c037038c037039c01e01dc011012101e6578616d706c652f696e737472756d656e742f4d794d61696e436c61737310a536f6d6520646174612ec015016703ac03b016703cc03d03e10106a6176612f6c616e672f4f626a656374106617070656e64102d284c6a6176612f6c616e672f537472696e673b294c6a6176612f6c616e672f537472696e674275696c6465723b101c2843294c6a6176612f6c616e672f537472696e674275696c6465723b10106f72672f736c66346a2f4c6f67676572104696e666f10176f72672f736c66346a2f4c6f67676572466163746f72791096765744c6f676765721025284c6a6176612f6c616e672f436c6173733b294c6f72672f736c66346a2f4c6f676765723b0210a010000201a0110120001201301400050001501601017000460202000a2affffffb7012a2bffffffb502ffffffb10002018000e03000f04010090110190001602000a01a01b00000a013014010101c01d010170002f010100052affffffb402ffffffb0000201800060100014019000c01000501a01b000101e01d010170004b020100021ffffffbb0359ffffffb704125ffffffb6062affffffb402ffffffb6061027ffffffb607107dffffffb607ffffffb608ffffffb0000201800060100019019000c010002101a01b000901f0200101700043040100015ffffffb209ffffffbb0a5912bffffffb70cffffffb60dffffffb90e20ffffffb10002018000a0200020014022019000c0100015021022000802302401017000220100000a130affffffb80fffffffb309ffffffb10001018000601000b010250002026
    63 [main] INFO example.instrument.MyClassFileTransformer - *****************************************
    63 [main] INFO example.instrument.MyMainClass - MyMainClass{data='Some data.'}


Demo AspectJ Weaver
-------------------

This is a functional example of the AspectJ Weaver library.

Sample output:

    mvn clean package exec:exec -Pdemo-weaver

    [AppClassLoader@fabe9] info AspectJ Weaver Version 1.6.10 built on Friday Oct 22, 2010 at 03:50:26 GMT
    [AppClassLoader@fabe9] info register classloader sun.misc.Launcher$AppClassLoader@fabe9
    [AppClassLoader@fabe9] info using configuration /C:/projects/sandbox/java/weaver-demo/target/classes/META-INF/aop.xml
    [AppClassLoader@fabe9] info register aspect example.weaver.MyListEnhancingAspect
    [AppClassLoader@fabe9] weaveinfo Join point 'method-call(java.lang.String example.weaver.ListHolder.toString())' in Type 'example.weaver.ExampleMain' (ExampleMain.java:24) advised by around advice from 'example.weaver.MyListEnhancingAspect' (MyListEnhancingAspect.java)
    [AppClassLoader@fabe9] weaveinfo Join point 'method-execution(java.util.List example.weaver.ListHolder.getList())' in Type 'example.weaver.ListHolder' (ListHolder.java:19) advised by afterReturning advice from 'example.weaver.MyListEnhancingAspect' (MyListEnhancingAspect.java)
    15 [main] INFO example.weaver.ExampleMain - [Foo, Bar, Baz, Surprise!!! :)]
    15 [main] INFO example.weaver.MyListEnhancingAspect - JoinPoint for call(public java.lang.String example.weaver.ListHolder.toString()) returned value 'ListHolder[Foo, Bar, Baz]'
    15 [main] INFO example.weaver.MyListEnhancingAspect - Throwing java.lang.SecurityException with message "No toString() for you!" instead.
    15 [main] ERROR example.weaver.ExampleMain - Unexpected Exception:
    java.lang.SecurityException: No toString() for you!!! ;)
        at example.weaver.MyListEnhancingAspect.replaceListHolderToString(MyListEnhancingAspect.java:36)
        at example.weaver.ExampleMain.main(ExampleMain.java:24)
        
# License

Creative Commons CC0 1.0 Universal 

See: http://creativecommons.org/publicdomain/zero/1.0/legalcode

Noah Zucker (nzucker@gmail.com / [@noahlz](http://twitter.com/noahlz))
