/**
 * KELAS DASAR (BASE CLASS): Mesin
 * Merepresentasikan mesin kendaraan dengan tenaga dan jenis bahan bakar.
 */
public class Mesin {
    private int    tenagaHP;
    private String jenisBahanBakar;
    private boolean menyala;

    public Mesin(int tenagaHP, String jenisBahanBakar) {
        this.tenagaHP        = tenagaHP;
        this.jenisBahanBakar = jenisBahanBakar;
        this.menyala         = false;
    }

    public void hidupkan() {
        menyala = true;
        System.out.println("  [Mesin] Mesin dihidupkan. Tenaga: " + tenagaHP + " HP.");
    }

    public void matikan() {
        menyala = false;
        System.out.println("  [Mesin] Mesin dimatikan.");
    }

    public boolean isMenyala() { return menyala; }
    public int getTenaga()     { return tenagaHP; }

    public String getInfo() {
        return tenagaHP + " HP | Bahan Bakar: " + jenisBahanBakar;
    }
}
