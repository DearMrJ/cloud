package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lynch
 * @date 2020/3/25 0:45
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int incrementAndGetModulo(int modulo) {
//        for (; ; ) {
//            int current = atomicInteger.get();
//            int next = (current + 1) % modulo;
//            if (atomicInteger.compareAndSet(current, next)) {
//                return next;
//            }
//        }
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = (current + 1) % modulo;
        } while (!atomicInteger.compareAndSet(current, next));  //自旋锁(当前值跟期望值一致，则进行修改，否则将一直取)
        return next;
    }

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));  //自旋锁(当前值跟期望值一致（即取时的值跟当前值相等），则进行修改，否则将一直取)
        System.err.println("***********next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
