/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minicad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MiniCAD extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtCorX, txtCorY, txtCor2x, txtCor2y;
    private JButton btnLinea, btnRombo, btnCirculo, btnCuadrado, btnTriangulo, btnRectangulo, btnSalir, btnColor;
    private JSlider sliderRotar, sliderEscalaX, sliderEscalaY, sliderTraslacionX, sliderTraslacionY;
    private JCheckBox chkUniforme;

    private int giro = 0;
    private double escaladoX = 1.0, escaladoY = 1.0;
    private int shapeType = 0;
    private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    private int xShape = 0, yShape = 0, widthShape = 0, heightShape = 0;
    private int traslacionX = 0, traslacionY = 0;
    private Color shapeColor = Color.BLACK;

    public MiniCAD() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MiniCAD");
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblCorX = new JLabel("X=");
        lblCorX.setBounds(10, 10, 20, 25);
        getContentPane().add(lblCorX);

        txtCorX = new JTextField();
        txtCorX.setBounds(35, 10, 50, 25);
        getContentPane().add(txtCorX);

        JLabel lblCorY = new JLabel("Y=");
        lblCorY.setBounds(95, 10, 20, 25);
        getContentPane().add(lblCorY);

        txtCorY = new JTextField();
        txtCorY.setBounds(120, 10, 50, 25);
        getContentPane().add(txtCorY);

        JLabel lblCor2x = new JLabel("Ancho=");
        lblCor2x.setBounds(10, 40, 50, 25);
        getContentPane().add(lblCor2x);

        txtCor2x = new JTextField();
        txtCor2x.setBounds(65, 40, 50, 25);
        getContentPane().add(txtCor2x);

        JLabel lblCor2y = new JLabel("Altura=");
        lblCor2y.setBounds(125, 40, 50, 25);
        getContentPane().add(lblCor2y);

        txtCor2y = new JTextField();
        txtCor2y.setBounds(180, 40, 50, 25);
        getContentPane().add(txtCor2y);

        btnLinea = new JButton("Linea");
        btnLinea.setBounds(10, 70, 80, 30);
        btnLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 = Integer.parseInt(txtCorX.getText());
                y1 = Integer.parseInt(txtCorY.getText());
                x2 = Integer.parseInt(txtCor2x.getText());
                y2 = Integer.parseInt(txtCor2y.getText());
                shapeType = 1;
                repaint();
            }
        });
        getContentPane().add(btnLinea);

        btnRombo = new JButton("Poligono");
        btnRombo.setBounds(100, 70, 80, 30);
        btnRombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                shapeType = 2;
                repaint();
            }
        });
        getContentPane().add(btnRombo);

        btnCirculo = new JButton("Circulo");
        btnCirculo.setBounds(10, 110, 80, 30);
        btnCirculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 3;
                repaint();
            }
        });
        getContentPane().add(btnCirculo);

        btnCuadrado = new JButton("Cuadrado");
        btnCuadrado.setBounds(100, 110, 80, 30);
        btnCuadrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 4;
                repaint();
            }
        });
        getContentPane().add(btnCuadrado);

        btnTriangulo = new JButton("Triangulo");
        btnTriangulo.setBounds(10, 150, 80, 30);
        btnTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 5;
                repaint();
            }
        });
        getContentPane().add(btnTriangulo);

        btnRectangulo = new JButton("Rectangulo");
        btnRectangulo.setBounds(100, 150, 100, 30);
        btnRectangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 6;
                repaint();
            }
        });
        getContentPane().add(btnRectangulo);

        btnColor = new JButton("Seleccionar Color");
        btnColor.setBounds(10, 190, 150, 25);
        btnColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Color color = JColorChooser.showDialog(MiniCAD.this, "Seleccione un color", Color.BLACK);
                if (color != null) {
                    shapeColor = color;
                    repaint();
                }
            }
        });
        getContentPane().add(btnColor);

        JLabel lblRotar = new JLabel("Rotar:");
        lblRotar.setBounds(10, 230, 50, 25);
        getContentPane().add(lblRotar);

        sliderRotar = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 0);
        sliderRotar.setBounds(60, 230, 140, 25);
        sliderRotar.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                giro = sliderRotar.getValue();
                repaint();
            }
        });
        getContentPane().add(sliderRotar);

        chkUniforme = new JCheckBox("Uniforme");
        chkUniforme.setBounds(130, 260, 100, 25);
        getContentPane().add(chkUniforme);

        JLabel lblEscalaX = new JLabel("Escala X:");
        lblEscalaX.setBounds(10, 290, 70, 25);
        getContentPane().add(lblEscalaX);

        sliderEscalaX = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
        sliderEscalaX.setBounds(80, 290, 140, 25);
        sliderEscalaX.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                escaladoX = sliderEscalaX.getValue() / 100.0;
                if (chkUniforme.isSelected())
                    escaladoY = escaladoX;
                repaint();
            }
        });
        getContentPane().add(sliderEscalaX);

        JLabel lblEscalaY = new JLabel("Escala Y:");
        lblEscalaY.setBounds(10, 320, 70, 25);
        getContentPane().add(lblEscalaY);

        sliderEscalaY = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
        sliderEscalaY.setBounds(80, 320, 140, 25);
        sliderEscalaY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                escaladoY = sliderEscalaY.getValue() / 100.0;
                if (chkUniforme.isSelected())
                    escaladoX = escaladoY;
                repaint();
            }
        });
        getContentPane().add(sliderEscalaY);

        JLabel lblTraslacionX = new JLabel("Traslación X:");
        lblTraslacionX.setBounds(10, 350, 80, 25);
        getContentPane().add(lblTraslacionX);

        sliderTraslacionX = new JSlider(SwingConstants.HORIZONTAL, -500, 500, 0);
        sliderTraslacionX.setBounds(100, 350, 140, 25);
        sliderTraslacionX.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                traslacionX = sliderTraslacionX.getValue();
                repaint();
            }
        });
        getContentPane().add(sliderTraslacionX);

        JLabel lblTraslacionY = new JLabel("Traslación Y:");
        lblTraslacionY.setBounds(10, 380, 80, 25);
        getContentPane().add(lblTraslacionY);

        sliderTraslacionY = new JSlider(SwingConstants.HORIZONTAL, -500, 500, 0);
        sliderTraslacionY.setBounds(100, 380, 140, 25);
        sliderTraslacionY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                traslacionY = sliderTraslacionY.getValue();
                repaint();
            }
        });
        getContentPane().add(sliderTraslacionY);

        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(10, 420, 170, 30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        getContentPane().add(btnSalir);

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                switch (shapeType) {
                    case 1: // Linea
                        g2d.translate(x1 + traslacionX, y1 + traslacionY);
                        g2d.rotate(Math.toRadians(giro));
                        g2d.setColor(shapeColor);
                        g2d.drawLine(0, 0, x2 - x1, y2 - y1);
                        break;
                        
                        
                    case 2: // Poligono (Carro)
                        double[] xPoints = {0, 90, 90, 60, 40, 20, 20, 0}; //{40, 130, 130, 100, 80, 60, 60, 40} //{200, 650, 650, 500, 400, 300, 300, 200}
                        double[] yPoints = {0, 0, -20, -28, -40, -40, -20, -20};//{40, 40, 60, 68, 80 80, 60, 60}      //{200, 200, 300, 340, 400, 400, 300, 300}
                        int numPoints = 8;

                        double centerX = (Arrays.stream(xPoints).max().getAsDouble() + Arrays.stream(xPoints).min().getAsDouble()) / 2;
                        double centerY = (Arrays.stream(yPoints).max().getAsDouble() + Arrays.stream(yPoints).min().getAsDouble()) / 2;
                           g2d.setColor(shapeColor);
                        for (int i = 0; i < numPoints; i++) {
                            xPoints[i] -= centerX;
                            yPoints[i] -= centerY;
                        }
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro), 0, 0);
                        g2d.fillPolygon(Arrays.stream(xPoints).mapToInt(x -> (int) (x * escaladoX)).toArray(),
                    Arrays.stream(yPoints).mapToInt(y -> (int) (y * escaladoY)).toArray(), numPoints);
                        break;
                        
                         ///Calcula el ancho y alto del polígono para ajustarlo a la ventana
//                            double maxX = Arrays.stream(xPoints).max().getAsDouble();
//                            double maxY = Arrays.stream(yPoints).max().getAsDouble();
//                            double minX = Arrays.stream(xPoints).min().getAsDouble();
//                            double minY = Arrays.stream(yPoints).min().getAsDouble();
//                            double width = maxX - minX;
//                            double height = maxY - minY;
//                            double scaledWidth = width * escaladoX;
//                            double scaledHeight = height * escaladoY;
//                            g2d.setColor(shapeColor);
//                        
//                            // Calcula el factor de traslación
//                            double translatedX = xShape + traslacionX;
//                            double translatedY = yShape + traslacionY;
//                        
//                            // Ajusta y escala los puntos del polígono
//                            int[] adjustedXPoints = Arrays.stream(xPoints)
//                                    .mapToInt(x -> (int) (((x - minX) * escaladoX) + translatedX))
//                                    .toArray();
//                            int[] adjustedYPoints = Arrays.stream(yPoints)
//                                    .mapToInt(y -> (int) (((y - minY) * escaladoY) + translatedY))
//                                    .toArray();
//                        
//                            g2d.translate((int) translatedX, (int) translatedY);
//                            g2d.rotate(Math.toRadians(giro));
//                        g2d.fillPolygon(adjustedXPoints, adjustedYPoints, numPoints);
//                        break;

                    case 3: // Circulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));
                        g2d.setColor(shapeColor);
                        g2d.fillOval(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;

                    case 4: // Cuadrado
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));
                        g2d.setColor(shapeColor);
                        g2d.fillRect(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;

                    case 5: // Triangulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));
                        g2d.setColor(shapeColor);
                        g2d.fillPolygon(new int[]{0, (int) (widthShape * escaladoX), (int) (widthShape * escaladoX / 2)},
                                new int[]{0, 0, (int) (heightShape * escaladoY)}, 3);
                        break;

                    case 6: // Rectangulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));
                        g2d.setColor(shapeColor);
                        g2d.fillRect(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;
                }
            }
        };
        panel.setBounds(230, 10, 670, 500);
        getContentPane().add(panel);

        setSize(700, 580);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniCAD().setVisible(true);
            }
        });
    }
}
