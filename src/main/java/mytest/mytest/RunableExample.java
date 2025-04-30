import java.util.concurrent.TimeUnit;

// 1. Runnable 인터페이스를 구현하는 클래스 정의
class MyRunnable implements Runnable {
    private String taskName;

    public MyRunnable(String name) {
        this.taskName = name;
        System.out.println(taskName + " 작업 생성됨.");
    }

    // 2. run() 메소드 구현: 스레드가 실행할 로직 정의
    @Override
    public void run() {
        // 현재 실행 중인 스레드의 이름을 얻어옴
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 에서 " + taskName + " 작업 실행 시작...");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(threadName + " (" + taskName + "), 카운트: " + i);
                TimeUnit.MILLISECONDS.sleep(150); // 0.15초 대기 (다른 방법)
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " (" + taskName + ") 작업 인터럽트됨.");
            Thread.currentThread().interrupt();
        }
        System.out.println(threadName + " 에서 " + taskName + " 작업 실행 종료.");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        System.out.println("메인 스레드 시작.");

        // 3. Runnable 객체(작업) 생성
        MyRunnable task1 = new MyRunnable("Task-Alpha");
        MyRunnable task2 = new MyRunnable("Task-Beta");

        // 4. Runnable 객체를 사용하여 Thread 객체 생성
        Thread thread1 = new Thread(task1, "WorkerThread-1"); // 스레드 이름 지정 가능
        Thread thread2 = new Thread(task2); // 스레드 이름 자동 할당됨 (예: Thread-1)

        // 5. 스레드 시작
        thread1.start();
        thread2.start();

        System.out.println("메인 스레드가 thread1, thread2 시작 요청함.");
        System.out.println("메인 스레드 종료.");
    }
}
