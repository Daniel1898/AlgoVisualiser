package com.daniel1898.algoVisualiser;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SortingAghoritms {

    public static AtomicBoolean isPause = new AtomicBoolean(false);
    public static AtomicBoolean isStop = new AtomicBoolean(false);

    public static Thread bubbleSortRun(ArrayList<SortingElement> elements) {
        Runnable runnable = () -> bubbleSort(elements);
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

    private static void bubbleSort(ArrayList<SortingElement> elements) {
        int size = elements.size();
        SortingElement e1;
        SortingElement e2;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size - j - 1; i++) {
                if (isStop.get()) {
                    isStop.set(false);
                    return;
                }
                while (isPause.get()) {
                    if (isStop.get()) {
                        return;
                    }
                    continue;
                }
                e1 = elements.get(i);
                e2 = elements.get(i + 1);
                if (e1.compareWith(e2) > 0) {
                    elements.set(i, e2);
                    elements.set(i + 1, e1);
                    SortingElement.swap(e1, e2);
                }
            }
        }
    }
}
