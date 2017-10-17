import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
public class Rewrite{

    public static void main(String[]args){
	ArrayList<Person> ppl = new ArrayList<>();
	ppl.add(new Person("Joe",Person.Sex.MALE));
	ppl.add(new Person("Nick",Person.Sex.MALE));
	ppl.add(new Person("Brenda",Person.Sex.FEMALE));
	ppl.add(new Person("Chuck",Person.Sex.MALE));
	Rewrite.rewrite3(ppl);
	Rewrite.original3(ppl);
	//4
	ArrayList<Album> albums = new ArrayList<>();
	Album temp;
	temp = new Album("No Favorite 0");
	temp.addTrack(new Track(3));
	albums.add(temp);
	temp = new Album("z.Favorite 0");
	temp.addTrack(new Track(4));
	albums.add(temp);
	temp = new Album("No Favorite 1");
	temp.addTrack(new Track(1));
	albums.add(temp);
	temp = new Album("a.Favorite 1");
	temp.addTrack(new Track(5));
	albums.add(temp);
	System.out.println(albums);
	ArrayList<Album> favs = Rewrite.original4(albums);
	System.out.println(favs);
	favs= Rewrite.rewrite4(albums);
	System.out.println(favs);
    }

    public static void original3(ArrayList<Person> roster){
	for (Person p : roster) {
	    if (p.getGender() == Person.Sex.MALE) {
		System.out.println(p.getName());
	    }
	}
    }

    public static void rewrite3(ArrayList<Person> roster){
	roster.stream()
	    .filter(e -> e.getGender() == Person.Sex.MALE)
	    .forEach(e -> System.out.println(e.getName()));
    }

    
    static class Person{
	private int gender;
	private String name;

	public Person(String name, int gender){
	    this.name = name;
	    this.gender = gender;
	}
	public int getGender(){
	    return gender;
	}
	public String getName(){
	    return name;
	}
	    
	class Sex{
	    public static final int FEMALE = 0;
	    public static final int MALE = 1;
	}
    }

    //===================================================

    public static ArrayList<Album> original4(ArrayList<Album> albums){
	List<Album> favs = new ArrayList<>();
	for (Album a : albums) {
	    boolean hasFavorite = false;
	    for (Track t : a.tracks) {
		if (t.rating >= 4) {
		    hasFavorite = true;
		    break;
		}
	    }
	    if (hasFavorite)
		favs.add(a);
	}
	Collections.sort(favs, new Comparator<Album>() {
		public int compare(Album a1, Album a2) {
		    return a1.name.compareTo(a2.name);
		}});
	return (ArrayList<Album>)favs;
    }

    public static ArrayList<Album> rewrite4(ArrayList<Album> albums){
	ArrayList<Album> favs = albums.stream()
	    .filter(a -> a.tracks.stream().anyMatch(t -> t.rating >=4))
	    .sorted((a1, a2)-> a1.name.compareTo(a2.name))
	    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	return favs;
    }
    
    static class Album{
	String name;
	ArrayList<Track> tracks;
	public Album(String name){
	    this.name=name;
	    tracks = new ArrayList<>();
	}
	public void addTrack(Track t){
	    tracks.add(t);
	}
	public String toString(){
	    return name;
	}
    }
    static class Track{
	int rating;
	public Track(int rating){
	    this.rating=rating;
	}
    }
}
