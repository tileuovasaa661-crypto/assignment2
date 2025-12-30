import java.util.ArrayList;
import java.time.Year;

public class Main {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        // Video lectures
        items.add(new VideoLecture("Java Basics", 2024, 60, "HD"));
        items.add(new VideoLecture("OOP Concepts", 2023, 45, "4K"));

        // Podcasts
        items.add(new PodcastEpisode("Tech Talk", 2022, 30, "Alice"));
        items.add(new PodcastEpisode("Dev Stories", 2024, 25, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(
                    item + " | licenseCost=" +
                            item.getLicenseCost(currentYear)
            );

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println(
                        "Max downloads/day: " +
                                d.getMaxDownloadsPerDay()
                );
            }

            System.out.println("----------------------------");
        }
    }
}
