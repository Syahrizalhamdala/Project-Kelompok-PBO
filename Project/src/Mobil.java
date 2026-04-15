/**
 * KELAS IMPLEMENTASI: Mobil
 * ─ extends    Kendaraan      (Kelas Abstract)
 * ─ implements IBisaBergerak  (Interface 1)
 * ─ implements IDapatDiisi    (Interface 2)
 * ─ has-a      Mesin          (Kelas Dasar / komposisi)
 */
public class Mobil extends Kendaraan implements IBisaBergerak, IDapatDiisi {

    private int    jumlahPintu;
    private double kapasitasTangki; // liter
    private double sisaBBM;         // liter
    private Mesin  mesin;           // Komposisi dengan Kelas Dasar
    private boolean sedangBerjalan;

    // ------------------------------------------------------------------ //
    public Mobil(String merk, int tahun, int jumlahPintu,
                 double kapasitasTangki, Mesin mesin) {
        super(merk, tahun);               // panggil konstruktor Kendaraan
        this.jumlahPintu    = jumlahPintu;
        this.kapasitasTangki = kapasitasTangki;
        this.sisaBBM        = kapasitasTangki * 0.5; // mulai setengah penuh
        this.mesin          = mesin;
        this.sedangBerjalan = false;
    }

    // ---- Override dari Kendaraan (Abstract) --------------------------- //
    @Override
    public void infoKendaraan() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         INFO KENDARAAN - MOBIL       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf ("║  Merk         : %-20s ║%n", merk);
        System.out.printf ("║  Tahun        : %-20d ║%n", tahun);
        System.out.printf ("║  Jumlah Pintu : %-20d ║%n", jumlahPintu);
        System.out.printf ("║  Mesin        : %-20s ║%n", mesin.getInfo());
        System.out.printf ("║  Tangki       : %.1f / %.1f Liter      ║%n",
                           sisaBBM, kapasitasTangki);
        System.out.printf ("║  Kecepatan    : %-17.1f km/j ║%n", kecepatan);
        System.out.println("╚══════════════════════════════════════╝");
    }

    // ---- Implementasi IBisaBergerak ----------------------------------- //
    @Override
    public void bergerak() {
        if (sisaBBM <= 0) {
            System.out.println("  [Mobil] BBM habis! Tidak bisa bergerak.");
            return;
        }
        if (!mesin.isMenyala()) {
            mesin.hidupkan();
        }
        sedangBerjalan = true;
        tambahKecepatan(40);
        sisaBBM -= 2; // konsumsi BBM
        System.out.printf("  [Mobil] %s melaju! BBM tersisa: %.1f L%n",
                          merk, sisaBBM);
    }

    @Override
    public void berhenti() {
        if (!sedangBerjalan) {
            System.out.println("  [Mobil] Mobil sudah berhenti.");
            return;
        }
        kurangiKecepatan(kecepatan); // turunkan ke 0
        mesin.matikan();
        sedangBerjalan = false;
        System.out.println("  [Mobil] " + merk + " berhenti.");
    }

    // ---- Implementasi IDapatDiisi ------------------------------------- //
    @Override
    public void isi(double jumlah) {
        double ruang = kapasitasTangki - sisaBBM;
        double terisi = Math.min(jumlah, ruang);
        sisaBBM += terisi;
        System.out.printf("  [SPBU] Mengisi %.1f L — Tangki: %.1f/%.1f L%n",
                          terisi, sisaBBM, kapasitasTangki);
        if (terisi < jumlah) {
            System.out.printf("  [SPBU] Tangki penuh! %.1f L tidak tertampung.%n",
                              jumlah - terisi);
        }
    }

    @Override
    public double getKapasitas() { return kapasitasTangki; }

    // ---- Getter tambahan --------------------------------------------- //
    public double getSisaBBM()   { return sisaBBM; }
}
