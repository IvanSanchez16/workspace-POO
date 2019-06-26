package pfarchivostxt;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class AplPaint{
	public static void main( String[] args )
	{

		JFrame ventana = new JFrame("Paint");

		MiPanel panelDibujo = new MiPanel( "Paint" );		
		panelDibujo.setSize( 600,  500);
		panelDibujo.setVisible( true );
		ventana.add(panelDibujo);

		ventana.setJMenuBar(panelDibujo.barra);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(600,500);
		ventana.setVisible(true);
		panelDibujo.setBackground(Color.white);
	}
}

class MiPanel extends JPanel{ 

	private JMenuItem elementoNuevo;
	private JMenuItem elementoAbrir;
	private JMenuItem elementoGuardarC;
	private JMenuItem elementoImprimir;
	private JMenuItem elementoSalir;
	private JMenuItem elementoLinea;
	private JMenuItem elementoRectangulo;
	private JMenuItem elementoElipse;
	private JCheckBox chkRelleno;
	private JMenuItem elementoColor;
	private JMenuItem elementoAcercaDe;
	Shape		rectangulo, elipse, linea;
	Point2D		p1;
	Point2D		p2;
	Vector<Shape>	figuras;
	Vector<Color> 	colores;
	Vector<Boolean>    rellenos;
	JButton botonOk;
	//JFileChooser seleccionarArchivo, guardarArchivo;
	//FileNameExtensionFilter filtro;
	//ManejadorDeArchivos f;

	JMenuBar barra = new JMenuBar(); // crea la barra de menus
	public boolean puedeDibujar=false;
	public int figuraActual = -1;
	Color colorActual = Color.BLACK;
	boolean rellenarFigura = false;


	public MiPanel( String titulo ) {

		MiOyente miOyente = new MiOyente();
		MiOyente2 miOyente2 = new MiOyente2();

		ManejadorArchivo manejadorArchivo = new ManejadorArchivo(); // manejador de elementos del menu archivo
		ManejadorDibujo manejadorDibujo = new ManejadorDibujo(); // manejador de elementos del menu edicion
		JMenu menuArchivo = new JMenu( "Archivo" ); // crea el menu archivo
		elementoNuevo=new JMenuItem( "Nuevo");
		elementoAbrir=new JMenuItem("Abrir");
		elementoGuardarC = new JMenuItem("Guardar como...");
		elementoImprimir = new JMenuItem("Imprimir");
		elementoSalir = new JMenuItem("Salir");
		menuArchivo.setMnemonic( 'A' ); // establece el nemonico a A

		JMenu menuDibujar = new JMenu ("Dibujar"); //crea el menu edicion
		elementoLinea= new JMenuItem("Linea");
		elementoRectangulo= new JMenuItem("Rectangulo");
		elementoElipse = new JMenuItem("Elipse");
		chkRelleno = new JCheckBox("Relleno");
		elementoColor = new JMenuItem("Color");
		menuDibujar.setMnemonic( 'D' ); // establece el nemonico a E

		JMenu menuAyuda = new JMenu ("Ayuda"); //crea el menu Ayuda
		elementoAcercaDe = new JMenuItem( "Acerca de..." );
		menuAyuda.setMnemonic( 'A' ); // establece el nemonico a A
		elementoAcercaDe.setMnemonic('A');
		elementoSalir.setMnemonic( 'S' ); //establece el nemonico a S

		elementoNuevo.addActionListener(manejadorArchivo);
		elementoAbrir.addActionListener(manejadorArchivo);
		elementoGuardarC.addActionListener(manejadorArchivo);
		elementoImprimir.addActionListener(manejadorArchivo);
		elementoAcercaDe.addActionListener( manejadorArchivo );
		elementoSalir.addActionListener( manejadorArchivo );

		elementoLinea.addActionListener(manejadorDibujo);
		elementoRectangulo.addActionListener(manejadorDibujo);
		elementoElipse.addActionListener(manejadorDibujo);
		chkRelleno.addActionListener(manejadorDibujo);
		elementoColor.addActionListener(manejadorDibujo);


		menuArchivo.add( elementoNuevo ); //agrega el elemento "Nuevo" al menu Archivo
		menuArchivo.add( elementoAbrir ); //agrega el elemento "Abrir" al menu Archivo
		menuArchivo.add( elementoGuardarC ); //agrega el elemento "Guardar Como" al menu Archivo
		menuArchivo.add( elementoImprimir ); //agrega el elemento "Imprimir" al menu Archivo
		menuArchivo.add( elementoSalir ); //agrega el elemento "Salir" al menu Archivo

		menuDibujar.add(elementoLinea); //agrega el elemento "Fuente" al menu Edicion
		menuDibujar.add(elementoRectangulo); //agrega el elemento "Copiar" al menu Edicion
		menuDibujar.add(elementoElipse); //agrega el elemento "Copiar" al menu Edicion
		menuDibujar.add(chkRelleno); //agrega el elemento "Copiar" al menu Edicion
		menuDibujar.add(elementoColor); //agrega el elemento "Copiar" al menu Edicion
		menuAyuda.add(elementoAcercaDe); //agrega el elemento "Acerca de" al menu Ayuda

		barra.add( menuArchivo ); // agrega el menu archivo a la barra de menus
		barra.add( menuDibujar ); // agrega el menu edicion a la barra de menus
		barra.add( menuAyuda ); // agrega el menu ayuda a la barra de menus
		figuras = new Vector<Shape>();
		colores = new Vector<Color>();
		rellenos = new Vector<Boolean>();

		botonOk = new JButton();
		botonOk.setText( "Aceptar" );

		addMouseListener( miOyente2 );
		addMouseMotionListener( miOyente2 );
	}


	@Override
	public void paintComponent( Graphics g ){
		// Llamar a paintComponent de la clase JPanel
		super.paintComponent(g);

		// Obtener un objeto Graphics2D
		Graphics2D g2D = ( Graphics2D ) g;



		if(colorActual!=null) {
			g2D.setColor(colorActual);
		}


		if(rectangulo!=null) {
			if(rellenarFigura){
				g2D.fill(rectangulo);
			}else {
				g2D.draw(rectangulo);
			}
		}
		if(elipse!=null) {
			if(rellenarFigura){
				g2D.fill(elipse);
			}else {
				g2D.draw(elipse);
			}
		}
		if(linea!=null) {
			if(rellenarFigura){
				g2D.draw(linea); //Las lineas no se pueden rellenar, asÃ­ que de igual forma la dibujamos normalmente
			}else {
				g2D.draw(linea);
			}
		}




		//Dibujar
		for(int i=0; i<figuras.size(); i++) {

			if(colores.get(i)!=null){
				g2D.setColor(colores.get(i));

				if(rellenos.get(i)){
					if(figuras.get(i) instanceof Line2D.Double){
						g2D.draw(figuras.get(i));//Las lineas no se pueden rellenar, asi que de igual forma la dibujamos normalmente
					}
					else{
						g2D.fill(figuras.get(i));
					}

				}
				else{
					g2D.draw(figuras.get(i));
				}

			}

		}

	}






	// clase interna para manejar los eventos de accion de los elementos de menu Archivo
	private class ManejadorArchivo implements ActionListener    {
		public void actionPerformed( ActionEvent evento )      {
			JMenuItem fuente = (JMenuItem) evento.getSource();
			if( fuente == elementoNuevo) {
				repaint();
				figuras.clear();
			}
			if(fuente==elementoAbrir) {
				//	seleccionarArchivo = new JFileChooser();
			}
			if(fuente==elementoGuardarC) {
				/*
				for(int i=0 ; i<figuras.size() ; i++){
					
					
				}
				*/
			}
			if(fuente==elementoImprimir) {
				print();
			}

			if ( fuente == elementoAcercaDe )	  {
				JOptionPane.showMessageDialog( MiPanel.this,
						"Instituto Tecnologico de Culiacan\nFlores Tapia Maria Alejandra\nIng.Sistemas Computacionales,"
								+ "\nTopicos Avanzados de Programacion\nHorario: 8-9am",
								"Acerca de", JOptionPane.PLAIN_MESSAGE );
			}	  
			if (fuente == elementoSalir) {
				int opcionVentana = JOptionPane.showConfirmDialog(MiPanel.this, "¿Seguro que desea salir?","Salir", JOptionPane.YES_NO_OPTION);
				if(opcionVentana == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
			}
		}
	}
	// clase interna para manejar los eventos de accion de los elementos de menu Edicion
	private class ManejadorDibujo implements ActionListener {

		public void actionPerformed(ActionEvent evento) {

			if(evento.getSource() instanceof JCheckBox){
				rellenarFigura = chkRelleno.isSelected();
				return;
			}

			JMenuItem fuente = (JMenuItem) evento.getSource();
			MiOyente miOyente = new MiOyente();

			if(fuente== elementoLinea) {
				figuraActual = 1;
				puedeDibujar=true;
			}

			if(fuente==elementoRectangulo) {
				figuraActual = 2;
				puedeDibujar=true;

			}
			if (fuente==elementoElipse) {
				figuraActual = 3;
				puedeDibujar=true;
			}



			if(fuente==elementoColor) {
				JColorChooser ventanaDeColores = new JColorChooser();
				Color seleccionColor = ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);

				if(seleccionColor!=null) {
					colorActual = seleccionColor;
				}else { 

				}

			}

		}
	}

	private Shape crearLinea( Point2D p1, Point2D p2 )		{
		linea= new Line2D.Double( p1.getX(), p1.getY(), p2.getX(), p2.getY() );
		return linea;
	}
	private Shape crearRectangulo( Point2D p1, Point2D p2 )		{
		double x = Math.min( p1.getX(), p2.getX() );
		double y = Math.min( p1.getY(), p2.getY() );
		double ancho = Math.abs( p2.getX() - p1.getX() );
		double altura = Math.abs( p2.getY() - p1.getY() );

		rectangulo = new Rectangle2D.Double( x, y, ancho, altura );
		return rectangulo;
	}

	private Shape crearEllipse(Point2D p1, Point2D p2) {
		double x = Math.min( p1.getX(), p2.getX() );
		double y = Math.min( p1.getY(), p2.getY() );
		double ancho = Math.abs( p2.getX() - p1.getX() );
		double altura = Math.abs( p2.getY() - p1.getY() );
		elipse = new Ellipse2D.Double(x,y,ancho,altura);
		return elipse;
	}


	class MiOyente implements ActionListener, ListSelectionListener{
		public void actionPerformed( ActionEvent e )		{
			String cual = e.getActionCommand();
		}
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
		}
	}

	class MiOyente2 extends MouseAdapter{

		public void mousePressed( MouseEvent e )		{

			if(!puedeDibujar) {
				return;
			}
			MiPanel.this.setCursor( Cursor.getPredefinedCursor( Cursor.CROSSHAIR_CURSOR ) );
			p1 = e.getPoint();
		}

		public void mouseReleased( MouseEvent e )	{


			if(!puedeDibujar) {
				return;
			}
			MiPanel.this.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );
			p2 = e.getPoint();


			if(figuraActual == 1){
				//Linea
				linea= crearLinea(p1,p2);
				figuras.add(linea);
				linea=null;
				colores.add(colorActual);
				rellenos.add(rellenarFigura);
			}
			else if(figuraActual == 2){
				//Rectangulo
				rectangulo = crearRectangulo( p1, p2 );
				figuras.add( rectangulo );
				rectangulo = null;
				colores.add(colorActual);
				rellenos.add(rellenarFigura);
			}
			else if(figuraActual == 3){
				//Elipse
				elipse = crearEllipse(p1,p2);
				figuras.add(elipse);
				elipse = null;
				colores.add(colorActual);
				rellenos.add(rellenarFigura);
			}

			repaint();
		}

		public void mouseDragged( MouseEvent e )		{
			if(!puedeDibujar) {
				return;
			}
			Graphics2D g2D = ( Graphics2D ) MiPanel.this.getGraphics();


			if(figuraActual == 1){
				//Linea
				if(linea!=null) {
					g2D.setXORMode(MiPanel.this.getBackground());
					g2D.draw(linea);
				}

				//Dibujar figura nueva
				p2= e.getPoint();
				linea= crearLinea(p1,p2);
				g2D.setXORMode(MiPanel.this.getBackground());
				repaint();
			}
			else if(figuraActual == 2){
				//Rectangulo

				// Borrar la anterior
				if ( rectangulo != null ){
					g2D.setXORMode( MiPanel.this.getBackground() );
					g2D.draw( rectangulo );
				}


				// Dibujar figura nueva
				p2 = e.getPoint();
				rectangulo = crearRectangulo( p1, p2 );
				g2D.setXORMode( MiPanel.this.getBackground() );
				repaint();

			}
			else if(figuraActual == 3){
				//Elipse
				// Borrar la anterior
				if ( elipse != null )
				{
					g2D.setXORMode( MiPanel.this.getBackground() );
					g2D.draw( elipse );
				}


				// Dibujar figura nueva
				p2 = e.getPoint();
				elipse = crearEllipse( p1, p2 );
				g2D.setXORMode( MiPanel.this.getBackground() );
				repaint();

			}

		}
	}
	public void print()	{
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName(" Programa de Dibujo ");

		pj.setPrintable ( new Printable(){    
			public int print(Graphics pg, PageFormat pf, int numeroPagina)
			{
				if ( numeroPagina > 0 )
				{
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				double factorEscalaX = 100.0;
				double factorEscalaY = 100.0;
				g2.scale(factorEscalaX/pf.getImageableWidth(), factorEscalaY/pf.getImageableHeight());
				paint(g2);
				return Printable.PAGE_EXISTS;
			}
		}
				);

		if (pj.printDialog() == false)
			return;

		try
		{
			pj.print();
		}
		catch (PrinterException ex)
		{
			// Manejo de la excepción
		}
	}

}// fin de la clase 