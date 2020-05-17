package cn.hezhiren.service.impl;

/**
 * @author : hezr
 * @description :
 * @date : 2020/05/11
 **/
public class TestService {

    public static void main(String[] args) throws Exception{
        int a;
        for(a=0; a<=1; a++ ) {
            a++;
        }
        System.out.println(a);

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<String> stringFuture = executor.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(2000);
//                return "async thread";
//            }
//        });
//        Thread.sleep(1000);
//        System.out.println("main thread");
//        System.out.println(stringFuture.get());

//        List<String> list = new ArrayList<String>();
//
//        list.add("s1");
//        list.add("s2");
//        list.add(null);
//        list.add("s3");
//        list.add(null);
//        list.add("s4");
//
//        List<String> resultList = Collections.singletonList(null);
//
//        list.removeAll(resultList);
//
//        System.out.println(list);
    }
}
