import java.util.Random;

public class Deck {
    private Card[] cards = new Card[24];                                                       // Массив для хранения карт
    private String[] suits = {"Бубны", "Черви", "Крести", "Пики"};                             // Массив для мастей
    //                           0        1        2        3                                  позиции в масиве
    private int count = 0;                                                                     // Счетчик для мастей
    private int countValue = 0;                                                               // Счетчик для достоинств
    private String[] values = {"Девятка",  "Валет", "Дама", "Король", "Десятка", "Туз"};       // Массив достоинств
    //                           0           1         2         3       4         5          позиции в масcиве
    private Random random =  new Random();                                                   // Генератор позиций для выдачи колоды
    private int[] positions = new int[24];                                                  // Массив, в который будем запоминать какую карту уже выдали

    private Card[] player1 = new Card[6];                                                   // Массив для карт первого игрока
    private Card[] player2 = new Card[6];                                                   // Массив для карт второго игрока

    private int[] costs = {1, 2, 3, 4, 5, 6};

    public void generateDeck(){
        for (int i = 0; i < cards.length; i++) {                                          // цикл для заполнения   колоды
            if(count == 0){                                                               // В каждом if проверяю какой счетчик масти и достоинства и по счетчику заполняю карту, т.е. извлекаю из массива масть и достоинтсво
                cards[i] = new Card(suits[count], values[countValue], costs[countValue] );                    // в каждом if меняю счетчик масти
                System.out.println("Генерируем: " + suits[count] + " " + values[countValue] +  " " +  costs[countValue]);
                count++;
            }
            else if(count == 1){
                cards[i] = new Card(suits[count], values[countValue], costs[countValue] );
                System.out.println("Генерируем: " + suits[count] + " " + values[countValue]+  " " +  costs[countValue]);
                count++;
            }
            else if(count == 2){
                cards[i] = new Card(suits[count], values[countValue], costs[countValue] );
                System.out.println("Генерируем: " + suits[count] + " " + values[countValue]+  " " +  costs[countValue]);
                count++;
            }
            else if(count == 3){
                cards[i] = new Card(suits[count], values[countValue], costs[countValue] );
                System.out.println("Генерируем: " + suits[count] + " " + values[countValue]+  " " +  costs[countValue]);
                count = 0;
                countValue++;                                                         // Когда достоинство всех мастей есть в колоде меняю счетчик достоинств
            }
        }
    }

    public void distributeCards(){
        for (int i = 0; i < 6; i++) {
            int pos = random.nextInt(24);                                            // Выбираю одну карту из колоды
            while (positions[pos] != 0){                                             // Пока не найдем пустое значение, т.е. индекс не использованной карты, продолжаем генерировать число
                pos = random.nextInt(24);                                            // Выбираю одну карту из колоды
            }
            positions[pos] = pos;                                                    // После того как в цикле while, еще не использованную карту, добавляем ее в массив карт первого игрока
            player1[i] = cards[pos];                                                 // и учитываем ее как уже выданную
            cards[pos] = null;                                                       // Удаляем карту из колоды
        }
        // Повторяем алгоритм для второго игрока
        for (int i = 0; i < 6; i++) {
            int pos = random.nextInt(24);                                            // Выбираю одну карту из колоды
            while (positions[pos] != 0){                                             // Пока не найдем пустое значение, т.е. индекс не использованной карты, продолжаем генерировать число
                pos = random.nextInt(24);                                            // Выбираю одну карту из колоды
            }
            positions[pos] = pos;                                                    // После того как в цикле while, еще не использованную карту, добавляем ее в массив карт первого игрока
            player2[i] = cards[pos];                                                 // и учитываем ее как уже выданную
            cards[pos] = null;                                                       // Удаляем карту из колоды
        }
    }

    public Card giveCard(){
        int rand = random.nextInt(24);                                             // Генерируем случайное число
        while (cards[rand] == null){                                               // Проверяем есть ли карта по этой позиции
            rand = random.nextInt(24);                                             // Если нет, генерируем новое число
        }
        Card temp = cards[rand];                                                   // Запоминаем выбранную карту
        cards[rand] = null;                                                        // Удаляем выбранную карту из массива
        System.out.println("Колода отдала карту: " + temp.toString());
        return temp;                                                              // Возвращаем карту по сгенерированной позиции
    }

    public Card[] getPlayer1() {                                                   // Геттер для первого игрока
        return player1;
    }

    public Card[] getPlayer2() {                                                   // Геттер для второго игрока
        return player2;
    }

    public void display(){
        System.out.println("Колода карт: ");                                             // Вывожу на консоль сгенерированный массив карт
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {                                                      // Если ссылка равна null, т.е. карты нет, то выводим сообщение - Null
                System.out.println("Null");
            }
            else {                                                                    // В противном случае выводим элемент
                System.out.println(cards[i].toString());                                    // Вызываю метод toString у каждого объекта массива
            }
        }

    }

}
