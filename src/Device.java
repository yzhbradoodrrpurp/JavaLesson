public class Device {
    public enum Mode{Master}
    
    private String address;
    private String essid;
    private Mode mode;
    private byte channel;
    private byte signal;
    private String quality;
    private String encryption;

    public Device(String address, String essid, Mode mode, byte channel, byte signal, String quality, String encryption){
        this.address = address;
        this.essid = essid;
        this.mode = mode;
        this.channel = channel;
        this.signal = signal;
        this.quality = quality;
        this.encryption = encryption;
    }

    public String getAddress() {
        return address;
    }

    public String getESSID() {
        return essid;
    }

    public Mode getMode() {
        return mode;
    }

    public byte getChannel() {
        return channel;
    }

    public byte getSignal() {
        return signal;
    }

    public String getQuality() {
        return quality;
    }

    public String getEncryption() {
        return encryption;
    }

    @Override
    public String toString() {
        return "Device{" +
                "address='" + address + '\'' +
                ", essid='" + essid + '\'' +
                ", mode=" + mode +
                ", channel=" + channel +
                ", signal=" + signal +
                ", quality='" + quality + '\'' +
                ", encryption='" + encryption + '\'' +
                '}';
    }
}
