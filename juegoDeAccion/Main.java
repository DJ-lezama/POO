class Main
{
    public static void main(String[] args) 
    {
        System.out.println("Juego de acción");

        //Código para mostras los tipos de personajes del juego

        Character King, Queen, Knight, Troll;

        King = new King();
        Queen = new Queen();
        Troll = new Troll();
        Knight = new Knight();

        //llama a todos los println y enseña los diferentes personajes
        King.showCharacter();
        Queen.showCharacter();
        Knight.showCharacter();
        Troll.showCharacter();
    }
}
