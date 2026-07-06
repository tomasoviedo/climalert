package ar.edu.utn.frba.dds.models.entities;

public class Icono {
  public static final Icono FIRE = new Icono(new int[] {0x26A0});
  private final int[] internalEncoding;

  private Icono(int[] internalEncoding) {
    this.internalEncoding = internalEncoding;
  }

  public String texto() {
    return new String(internalEncoding, 0, internalEncoding.length);
  }
}
