package demo.java;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ThreadsCores {
    public static void main(String[] args) {

        float totalNumberCores = 0;
        float totalNumberThreads = 0;
        double totalTasksPerDay = 0;

        float totalNumberTasksPerInfraStructurePerSec = 1000;
        float waitTime = 350;
        float cpuTime = 50;

        float totalTimePerTask = cpuTime + waitTime;

        float numberOfCores = 1;
        float blockingCoefficient = waitTime / cpuTime;

        float threadsPerCore = (blockingCoefficient + 1) * numberOfCores;

        System.out.println("threadsPerCore : " + threadsPerCore);

        float tasksPerThread = 1000 / totalTimePerTask;

        System.out.println("tasksPerThread : " + tasksPerThread);

        float numer0fTasksPerSecondPerCorePerThread = tasksPerThread * threadsPerCore;

        System.out.println("numerOfTasksPerSecondPerCorePerThread : " + numer0fTasksPerSecondPerCorePerThread);

        totalNumberCores = totalNumberTasksPerInfraStructurePerSec / numer0fTasksPerSecondPerCorePerThread;

        System.out.println("totalNumberCores : " + totalNumberCores);

        System.out.println("totalNumberTasksPerInfrastructurePerSec :" + totalNumberTasksPerInfraStructurePerSec);

        totalNumberThreads = threadsPerCore * totalNumberCores;

        System.out.println("totalNumberThreads : " + totalNumberThreads);

        totalTasksPerDay = 86400 * tasksPerThread * threadsPerCore * totalNumberCores;

        BigInteger bigInteger = new BigDecimal(totalTasksPerDay).toBigInteger();

        System.out.println("totalTasksPerDay : " + bigInteger);

    }
}