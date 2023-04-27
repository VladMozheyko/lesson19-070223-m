public class Player {
    private String name;                                       // Поля класса
    private Card[] cards;
    private int count = 0;


    public Player(String name, Card[] cards) {                 // Конструктор
        this.name = name;
        this.cards = cards;
        count = cards.length;                                 // Получаем длину массива - количество карт
    }

    public void displayCards(){                               // Метод для отображения карт игрока
        for (int i = 0; i < cards.length; i++) {
            if(cards[i] == null){                              // Если карты нет, вывожу сообщение
                System.out.println("null");
            }
            else {
                System.out.println(cards[i].toString());      // Если карта есть, вывожу ее
            }
        }
    }

    public Card makeMove(int number){                         // Метод для того, чтобы сделать ход
        System.out.println(name + " сделал ход картой: " + cards[number]);   // Вывожу карту и имя игрока
        Card temp = cards[number];
        cards[number] = null;                                     // Удаляю карту
        count--;
        return temp;
    }

    public int getCount() {                                   // Возвращаем количество карт
        return count;
    }

    public void add(Card card){
        for (int i = 0; i < cards.length; i++) {
            if(cards[i] == null){
                cards[i] = card;
            }
        }
        System.out.println("Игрок взял карту: " + card.toString());
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }
}
