package com.cloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 定制ribbon负载均衡策略   同时在app类上使用注解RibbonClient
 */
public class IIORule extends AbstractLoadBalancerRule {

    private int total = 0; // 总共被调用次数
    private int currentIndex = 0; // 当前  提供服务的机器号


    public Server choose(ILoadBalancer lb, Object key){
        if(lb == null){
            return null;
        }

        List<Server> upList = lb.getReachableServers();
        Server server = upList.get(0);

        System.out.println("=============="+server.getPort());
        System.out.println("=============="+server.getZone());

        return server;
        /*Server server = null;
        while (server == null){
            if(Thread.interrupted()){
                return null;
            }
            // 获取所有有效的服务实例列表
            List<Server> upList = lb.getReachableServers();
            //获取所有的服务实例的列表
            List<Server> allList = lb.getAllServers();
            //如果没有任何的服务实例则返回 null
            int serverCount = allList.size();
            if(serverCount == 0){
                return null;
            }
            //与随机策略相似，但每个服务实例只有在调用 3 次之后，才会调用其他的服务实例
            System.out.println("---------------------------------"+upList.toString());
            System.out.println("---------------------------------");
            if(total < 3){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if( currentIndex  >= upList.size()){
                    currentIndex = 0;
                }
            }

            if(server == null){
                Thread.yield();
                continue;
            }
            if(server.isAlive()){
                return server;
            }

            server = null;
            Thread.yield();
        }*/
      //  return upList.get(0);
    }


    @Override
    public Server choose(Object o) {
        return this.choose(this.getLoadBalancer(),o);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
