package asesorias;

public class Cancion {
	protected String titl;
	protected String autor;
	protected int dur;
	protected static int LARGO=22+22+4+1;
	
	Cancion(String t, String a, int d){
		titl=t;
		autor=a;
		dur=d;
	}

	public String getTitl() {
		return titl;
	}

	public void setTitl(String titl) {
		this.titl = titl;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getDur() {
		return dur;
	}

	public void setDur(int dur) {
		this.dur = dur;
	}
	
	public String reprod() {
		return "Está sonando la canción " + titl + " del artista " + autor;
	}
	
	public String toString() {
		return "Título: " + titl + "\nAutor: " + autor + "\nDuración: " + dur;
	}
	
}
