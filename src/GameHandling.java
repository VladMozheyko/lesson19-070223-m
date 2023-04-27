import java.util.Scanner;

public class GameHandling {
    private Player player1;
    private Player player2;
    private Deck deck;

    public GameHandling(String name1, String name2) {
        deck = new Deck();                                // Создал объект колоды
        deck.generateDeck();                              // Заполнил его картами
        deck.distributeCards();                           // Раздал карты игрокам
        player1 = new Player(name1, deck.getPlayer1());   // Создал первого игрока, передал имя и карты
        player2 = new Player(name2, deck.getPlayer2());   // Создал второго игрока, передал имя и карты
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);                                    // Делаем ввод с консоли
        while (true){                                                                 // Игровой цикл
            System.out.println("Очередь первого игрока: ");
            Card card1 = player1.makeMove(scanner.nextInt());                       // Запоминаем выбранную для хода карту игроком 1
            player1.add(deck.giveCard());                                           // Передаем карту игроку
            System.out.println("Колода игрока " + player1.getName() + " : ");       // Выводим на консоль карты игрока 1
            for (int i = 0; i < player1.getCards().length; i++) {
                System.out.println(player1.getCards()[i].toString());
            }
            System.out.println("Очередь второго игрока: ");
            Card card2 = player2.makeMove(scanner.nextInt());                        // Запоминаем выбранную для хода карту игроком 2
            player2.add(deck.giveCard());                                           // Передаем карту игроку
            System.out.println("Колода игрока " + player2.getName() + " : ");        // Выводим на консоль карты игрока 2
            for (int i = 0; i < player2.getCards().length; i++) {
                System.out.println(player2.getCards()[i].toString());
            }

            if(isBeaten(card1, card2)){                                             // Проверяем кто победил на этом ходе
                System.out.println("В ходе победил игрок " + player1.getName());
            }
            else
            {
                System.out.println("В ходе победил игрок " + player2.getName());
            }



            System.out.println("Колода: ");                                  // Отображаем колоду
            deck.display();
        }
    }

    public boolean isBeaten(Card card1, Card card2){                         // Логический метод для проверки чья карта старше
        if(card1.getCost() > card2.getCost()){
            return true;
        }
        else {
            return false;
        }
    }


}
