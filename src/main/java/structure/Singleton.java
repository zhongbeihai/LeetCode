package structure;

public class Singleton {
    private Singleton() {}

    private static class Holder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Holder.instance;
    }
}

//public class Singleton {
//    private static volatile Singleton instance;
//
//    private static Singleton getInstance(){
//        if (instance == null){
//            synchronized (Singleton.class){
//                if (instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//
//        return instance;
//    }
//
//}
