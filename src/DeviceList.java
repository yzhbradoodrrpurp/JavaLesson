import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceList {
    private ArrayList<Device> devices;

    public DeviceList(){
        devices = new ArrayList<>();
    }

    public void addDevice(Device device){
        devices.add(device);
    }

    public void deleteDevice(int idx){
        assert idx >= 0 && idx < devices.size(): "Index out of bounds";
        devices.remove(idx);
    }

    public void scanTxt(String path){
        Scanner sc = null;
        try{
            File f = new File(path);
            sc = new Scanner(f);
            sc.useDelimiter("(?=Cell)");

            Pattern addrP = Pattern.compile("Address:\\s*([0-9A-Fa-f:]{17})");
            Pattern essidP = Pattern.compile("ESSID:\\s*\"([^\"]*)\"|ESSID:\\s*(unknown)");
            Pattern modeP = Pattern.compile("Mode:\\s*(\\w+)");
            Pattern chanP = Pattern.compile("Channel:\\s*(\\d+)");
            Pattern sigP = Pattern.compile("Signal:\\s*(-?\\d+)");
            Pattern qualP = Pattern.compile("Quality:\\s*([0-9]+/[0-9]+)");
            Pattern encP = Pattern.compile("Encryption:\\s*(.+)");

            while(sc.hasNext()){
                String cell = sc.next();
                Matcher m;

                m = addrP.matcher(cell);
                String address = m.group(1).trim();

                m = essidP.matcher(cell);
                String essid = "";

                if(m.find()){
                    if(m.group(1) != null)
                        essid = m.group(1);
                    else if(m.group(2) != null)
                        essid = m.group(2);
                }

                m = modeP.matcher(cell);
                Device.Mode mode = Device.Mode.Master;

                if(m.find()){
                    String ms = m.group(1);
                    if(ms.equalsIgnoreCase("Master"))
                        mode = Device.Mode.Master;
                }

                m = chanP.matcher(cell);
                byte channel = 0;
                if(m.find()){
                    channel = (byte) Integer.parseInt(m.group(1));
                }

                m = sigP.matcher(cell);
                byte signal = 0;
                if(m.find()){
                    signal = (byte) Integer.parseInt(m.group(1));
                }

                m = qualP.matcher(cell);
                String quality = "";
                if(m.find()) quality = m.group(1).trim();

                m = encP.matcher(cell);
                String encryption = "";
                if(m.find()) encryption = m.group(1).trim();

                Device device = new Device(address, essid, mode, channel, signal, quality, encryption);
                addDevice(device);
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found: " + path);
        } finally {
            if(sc != null)
                sc.close();
        }
    }

    public ArrayList<Device> findAddress(String address){
        ArrayList<Device> filteredDevices = new ArrayList<>();

        for(Device device: devices){
            if (device.getAddress().equals(address)){
                filteredDevices.add(device);
                System.out.println(device);
            }
        }

        if(filteredDevices.isEmpty())
            return null;

        return filteredDevices;
    }

    public ArrayList<Device> findESSID(String essid){
        ArrayList<Device> filteredDevices = new ArrayList<>();

        for(Device device: devices){
            if (device.getESSID().equals(essid)){
                filteredDevices.add(device);
                System.out.println(device);
            }
        }


        if (filteredDevices.isEmpty())
            return null;

        return filteredDevices;
    }

    public ArrayList<Device> filterBySignal(byte minSignal, byte maxSignal){
        ArrayList<Device> filteredDevices = new ArrayList<>();

        for(Device device: devices){
            if (device.getSignal() >= minSignal && device.getSignal() <= maxSignal){
                filteredDevices.add(device);
                System.out.println(device);
            }
        }

        if (filteredDevices.isEmpty())
            return null;

        return filteredDevices;
    }

    public static void main(String[] args) {
        String path = "src/scanlist.txt";
        DeviceList wifiList = new DeviceList();
        wifiList.scanTxt(path);

        wifiList.findAddress("88:C3:97:C9:CC:7E");
        wifiList.findESSID("Haochuang");
        wifiList.findESSID("unknown");
        wifiList.filterBySignal((byte)-110, (byte)-50);
    }


}
