import java.util.Scanner;

public class ShopItems {

    int totalCount = 0;  // total geral (vegano + não vegano)

    // Classe aninhada NonVegan
    class NonVegan {
        int iceCreamCount = 0;
        int shakeCount = 0;
        int totalCount = 0;  // total de itens não veganos

        // método para aumentar contagem
        void increaseCount(int type, int count) {
            if (type == 1) {
                iceCreamCount += count;
            } else if (type == 2) {
                shakeCount += count;
            }
            this.totalCount += count;       // total não vegano
            ShopItems.this.totalCount += count;  // total geral
        }
    }

    // Classe aninhada Vegan
    class Vegan {
        int smoothieCount = 0;
        int slushieCount = 0;
        int totalCount = 0;  // total de itens veganos

        // método para aumentar contagem
        void increaseCount(int type, int count) {
            if (type == 3) {
                smoothieCount += count;
            } else if (type == 4) {
                slushieCount += count;
            }
            this.totalCount += count;       // total vegano
            ShopItems.this.totalCount += count;  // total geral
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShopItems shop = new ShopItems();
        ShopItems.NonVegan nonVegan = shop.new NonVegan();
        ShopItems.Vegan vegan = shop.new Vegan();

        System.out.println("Digite o número do pedido (1: sorvete, 2: shake, 3: smoothie, 4: raspadinha, 0: sair):");

        while (true) {
            int tipo = scanner.nextInt();
            if (tipo == 0) {
                break; // sai do loop ao digitar 0
            }

            System.out.println("Digite a quantidade:");
            int qtd = scanner.nextInt();

            if (tipo == 1) {
                nonVegan.increaseCount(tipo, qtd);
            } else if (tipo == 2) {
                nonVegan.increaseCount(tipo, qtd);
            } else if (tipo == 3) {
                vegan.increaseCount(tipo, qtd);
            } else if (tipo == 4) {
                vegan.increaseCount(tipo, qtd);
            } else {
                System.out.println("Tipo inválido, tente novamente.");
            }
        }

        scanner.close();

        System.out.println("Thank you for your order! Today we have sold " + shop.totalCount + " orders of sweetness!");
        System.out.println(nonVegan.totalCount + " items have been ice cream and shakes.");
        System.out.println(vegan.totalCount + " items have been smoothies and slushies.");
    }
}
