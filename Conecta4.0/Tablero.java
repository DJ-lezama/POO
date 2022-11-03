import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tablero extends JFrame
{    
    JButton matrizTablero[][] = new JButton[7][7]; //declaración del arreglo de batones
    public int row, column, turn, lastCol, lastRow, newRow; //declaración de variables
    public boolean btnClicked = false, gameOver = false; //variable booleana que dice si el boton con coordenadas [row][column] no ha sido seleccionado

    public Tablero()
    {
        Container container = getContentPane(); //crear contenedor
        container.setLayout(new GridLayout(7,7)); //definir el layout del contenedor

        for (row = 0; row < 7; row++) //ciclo for para recorrer la matriz
        {
            for (column = 0; column < 7; column++) 
            {
                //matrizTablero[row][column] = new JButton(row + "," + column); //creación de los botones con cordenas row, column impresas
                if (row == 6) //si la fila es la ultima del tablero
                {
                    matrizTablero[6][column] = new JButton("A"); //set text a A de available
                    matrizTablero[row][column].setBackground(null); //pintar el boton de color default
                }
                else
                {
                    matrizTablero[row][column] = new JButton("U"); //set text a U de unavailable
                    matrizTablero[row][column].setBackground(Color.BLACK); //pintar el boton de negro
            
                }
                matrizTablero[row][column].setBounds(20, 10, 360, 360); //medidas de la matriz

                container.setBounds(140, 15, 270, 300);//medidas de la matriz
                container.add(matrizTablero[row][column]); //agregar al contenedor
      

                ButtonHandler handler = new ButtonHandler(); //creador del handler
                matrizTablero[row][column].addActionListener(handler); //agregar el actionlistener a la matriz de botones

                setVisible(true); //hacerlo visible
            }
        }
    }

    private class ButtonHandler implements ActionListener
    {
        //handle button event
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource(); //creacion de variable tipo objeto para almacenar las coordenadas
            String s = " ";
            
            //while (gameOver == false)
            //{
                for (row = 0; row < 7; row++) //ciclo for para recorrer la matriz
                {
                    for (column = 0; column < 7; column++) 
                    {
    
                        if (source == matrizTablero[row][column]) //si las coordenadas de la matriz coinciden con el recorrido del ciclo
                        {
                            s = matrizTablero[row][column].getText(); //obtener el texto del boton clickeado
    
                            if ( s == "U" ) //if the button is unavailable escribir el siguiente mensaje
                            {
                                JOptionPane.showMessageDialog(null, "This cell is unavailable, please click on a button with the letter 'A'");
                            }
                            if (s == "A") //if the button is available
                            {
                                if (turn == 1) //si es el turno del primer jugador
                                {
                                    matrizTablero[row][column].setBackground(Color.YELLOW); //pintar el boton de azul
                                    matrizTablero[row][column].setFont(new Font("Arial", Font.PLAIN, 40)); //formato de la letra del boton
                                    matrizTablero[row][column].setText("X"); //escribir una X en el boton
    
                                    btnClicked = true; //cambiar el valor del boton a verdadero porque éste ya fue seleccionado
    
                                    if (btnClicked == true) //si el boton ya fue seleccionado anteriormente
                                    {
                                        matrizTablero[row][column].setEnabled(false); //desactivar el boton
                                    }
    
                                    //obtiene cordenadas de el ultimo botón clickeado
                                    lastCol = column; 
                                    lastRow = row;
                                    newRow = lastRow - 1; //le resta 1 a el numero de la ultima fila clickeada para obtener la nueva fila a desblowuar en esa columna
    
                                    matrizTablero[newRow][column].setText("A"); //settext a A en el boton de la fila superior a la clickeada en la misma columna
                                    matrizTablero[newRow][column].setBackground(null); //cambia el color de dicho boton
                                    //JOptionPane.showMessageDialog(null, "last col " + lastCol + " last row " + lastRow + " newrow "+newRow); //Linea para saber si la matriz registra bien la columna y fila
                                    turn = 2; //convertir de turno del jugador 2 a turno del jugador 1
    
                                    //winner checker 
                                    String lastPlay = matrizTablero[row][column].getText();
    
                                    for (int i = 0; i<7; i++) //i for rows
                                    {
                                        for (int j = 0; j<7; j++) //j for columns
                                        {
                                            //rows
                                            if (j + 3 < 7 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i][j + 1].getText() && lastPlay == matrizTablero[i][j + 2].getText() && lastPlay == matrizTablero[i][j+3].getText())
                                            {
                                                if (lastPlay == "X")
                                                {
                                                    JOptionPane.showMessageDialog(null,"Player 1 has connected four in a row");
                                                    gameOver = true;
                                                }
                                                if (lastPlay == "O")
                                                {
                                                    JOptionPane.showMessageDialog(null,"Player 2 has connected four in a row");
                                                    gameOver = true;
                                                }
                                            }
    
                                            //columns
                                            if (i + 3 < 7)
                                            {
                                                if (lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j].getText() && lastPlay == matrizTablero[i+2][j].getText() && lastPlay == matrizTablero[i+3][j].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four in a column");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four in a column");
                                                        gameOver = true;
                                                    }
                                                }
    
                                                //diagonal
                                                if (j + 3 < 7 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j+1].getText() && lastPlay == matrizTablero[i+2][j+2].getText() && lastPlay == matrizTablero[i+3][j+3].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                }
    
                                                //diagonal
                                                if (j-3>= 0 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j-1].getText() && lastPlay == matrizTablero[i+2][j-2].getText() && lastPlay == matrizTablero[i+3][j-3].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                }
                                            }
                                        }
                                    } 
    
                                    break;
                                }
    
                                if (turn == 2) //si es el turno del segundo jugador
                                {
                                    matrizTablero[row][column].setBackground(Color.RED); //pintar el boton de rojo
                                    matrizTablero[row][column].setFont(new Font("Arial", Font.PLAIN, 40)); //formato de la letra del boton
                                    matrizTablero[row][column].setText("O"); //escribir una O en el boton
    
                                    btnClicked = true; //cambiar el valor del boton a verdadero porque éste ya fue seleccionado
    
                                    if (btnClicked == true) //si el boton ya fue seleccionado anteriormente
                                    {
                                        matrizTablero[row][column].setEnabled(false); //desactivar el boton
                                    }
    
                                    //obtiene cordenadas de el ultimo botón clickeado
                                    lastCol = column; 
                                    lastRow = row;
                                    newRow = lastRow - 1; //le resta 1 a el numero de la ultima fila clickeada para obtener la nueva fila a desblowuar en esa columna
    
                                    matrizTablero[newRow][column].setText("A"); //settext a A en el boton de la fila superior a la clickeada en la misma columna
                                    matrizTablero[newRow][column].setBackground(null);//cambia el color de dicho boton
                                    //JOptionPane.showMessageDialog(null, "last col" + lastCol + "last row " + lastRow + " newrow "+newRow); //Linea para saber si la matriz registra bien la columna y fila
    
                                    turn = 1; //convertir de turno del jugador 2 a turno del jugador 1   
    
                                    //winner checker 
                                    String lastPlay = matrizTablero[row][column].getText();
    
                                    for (int i = 0; i<7; i++) //i for rows
                                    {
                                        for (int j = 0; j<7; j++) //j for columns
                                        {
                                            //look right
                                            if (j + 3 < 7 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i][j + 1].getText() && lastPlay == matrizTablero[i][j + 2].getText() && lastPlay == matrizTablero[i][j+3].getText())
                                            {
                                                if (lastPlay == "X")
                                                {
                                                    JOptionPane.showMessageDialog(null,"Player 1 has connected four in a row");
                                                    gameOver = true;
                                                }
                                                if (lastPlay == "O")
                                                {
                                                    JOptionPane.showMessageDialog(null,"Player 2 has connected four in a row");
                                                    gameOver = true;
                                                }
                                            }
    
                                            //look up
                                            if (i + 3 < 7)
                                            {
                                                if (lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j].getText() && lastPlay == matrizTablero[i+2][j].getText() && lastPlay == matrizTablero[i+3][j].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four in a column");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four in a column");
                                                        gameOver = true;
                                                    }
                                                }
    
                                                //diagonal derecha
                                                if (j + 3 < 7 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j+1].getText() && lastPlay == matrizTablero[i+2][j+2].getText() && lastPlay == matrizTablero[i+3][j+3].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                }
    
                                                //diagonal izquierda
                                                if (j-3>= 0 && lastPlay == matrizTablero[i][j].getText() && lastPlay == matrizTablero[i+1][j-1].getText() && lastPlay == matrizTablero[i+2][j-2].getText() && lastPlay == matrizTablero[i+3][j-3].getText())
                                                {
                                                    if (lastPlay == "X")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 1 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                    if (lastPlay == "O")
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Player 2 has connected four diagonally");
                                                        gameOver = true;
                                                    }
                                                }
                                            }
                                            
                                        }
    
                                    } 
    
                                    break;
                                }
                            }   
                        } 
                    }
                }   
            //}
        }
    }

    public static void main(String[] args)
    {
       Tablero application = new Tablero(); //declara la aplicacion
       application.setDefaultCloseOperation(EXIT_ON_CLOSE); //termina el programa al cerrarlo

    }
}