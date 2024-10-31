package java_8.lambda_expressions;

public class Exemplo01 {

    public static void main(String[] args) {
        // Forma tradicional de implementar usando Runnable sem Expressões Lambda
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread tradicional com Runnable sem expressão lambda");
                    }
                }
        );
        thread1.start();

        // Forma recomendada a partir do Java 8 (Veja ExecutorsService)
        Thread thread2 = new Thread(() -> System.out.println("Thread usando Runnable em uma expressão lambda"));
        thread2.start();
    }

}
