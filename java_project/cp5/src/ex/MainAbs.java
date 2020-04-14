package ex;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class MainAbs {
    public static void main(String args[]){
        Abs abs = new Abs();
        Abs abs2 = new Abs();
        int result = abs.absResult(-5, 15);

        System.out.println(result);
    }
}
