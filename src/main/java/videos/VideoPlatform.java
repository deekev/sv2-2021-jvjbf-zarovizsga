package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return new ArrayList<>(channels);
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                fillChannels(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }

    private void fillChannels(String line) {
        String[] temp = line.split(";");
        String name = temp[0];
        int subscribes = Integer.parseInt(temp[1]);
        int videos = Integer.parseInt(temp[2]);
        Channel channel = new Channel(name, subscribes, videos);
        addChannel(channel);
    }
}
