//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class MusicOrganizer {
//
//    private static ArrayList<String> tracks = new ArrayList<String>();
//
//    public static void removeTrack(String nameLike) {
//        Iterator<String> it = tracks.iterator();
//        while (it.hasNext()) {
//            if (it.next().contains(nameLike))
//                it.remove();
//        }
//    }
///*
//// This piece of code will do the same
//    public void removeTrack(String nameLike) {
//        tracks.removeIf(s -> s.contains(nameLike));
//    }
// */
//
//    public static void main(String[] args) {
//        tracks.add("Nari Nari Nari");
//        tracks.add("Asghar sarbaz");
//        tracks.add("Man 2");
//        tracks.add("I don't know");
//        System.out.println(tracks);
//        removeTrack("Man 2");
//        System.out.println(tracks);
//
//    }
//
//}
//
