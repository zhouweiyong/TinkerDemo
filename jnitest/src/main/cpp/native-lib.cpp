#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_vst_jnitest_JniTest_sayHello(JNIEnv *env, jobject instance) {

    // TODO


    return env->NewStringUTF("Hello Jni Fixxxxxx!!!");
}