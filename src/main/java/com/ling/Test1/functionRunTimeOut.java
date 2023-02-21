package com.ling.Test1;

import java.util.concurrent.*;

/**
 * @Author wanglz
 * @create 2022/2/16 16:14
 */
public class functionRunTimeOut {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                // TODO Auto-generated method stub
                Thread.sleep(6000);
                System.out.println("---------aaaa------------");
                return "aaa";
            }
        });
        executor.execute(future);
        try {
            String result = future.get(5000, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            System.out.println("TimeOut:" + e.getMessage());
        }finally{
            future.cancel(true);
            executor.shutdown();
        }

    }
}
