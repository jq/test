import java.util.ArrayList;
import java.util.List;



class LocalSearch {
    private static class Location {
          public Location(double lat_, double lng_) {
              lat = lat_;
              lng = lng_;
          }
          public double distance(Location loc) {
              double x = Math.abs(lat - loc.lat);
              double y = Math.abs(lng - loc.lng);
              return Math.sqrt(x*x + y*y);
          }
          @Override public String toString() {
              return "Location{" +
                  "lat=" + lat +
                  ", lng=" + lng +
                  '}';
          }
          public double lat;
          public double lng;
        };
    private static  class POI {
          public POI(double lat_, double lng_, String title_) {
              loc = new Location(lat_, lng_);
                title = title_;
          };
          public double distance(Location loc_) {
            return loc_.distance(loc);
          };  
          @Override public String toString() {
              return "POI{" +
             "loc=" + loc +
             ", title='" + title + '\'' +
             ", rank=" + rank +
             '}';
             }

          Location loc;
          String title;
          double rank;
    };
    
  //private HashMap<String, POI> pois;
  // private HashMap<Location, POI> pois;
  private final static double DISTANCE = 1.0;
  List<POI> pois = new ArrayList<POI>();
  public LocalSearch() {
  
    POI p1 = new POI(1.1, 1.2, "a");
    POI p2 = new POI(1.1, 2.2, "b");
    pois.add(p1);
    pois.add(p2);
//    for (POI p : poi_) {
//      pois.put(p.loc, p);
//    }
    
  }
  //public List<POI> search(String query, Location loc) {
  //}
  
  public List<POI> search(Location loc) {
      List<POI> result = new ArrayList<POI>();
      for (POI p : pois) {
          if (p.distance(loc) < DISTANCE) {
              result.add(p);
          }
      }
      return result;
  }

  public static void main(String[] args) {
    LocalSearch localSearch = new LocalSearch();
    Location loc = new Location(1.2, 1.5);
    List<POI> results = localSearch.search(loc);
    for(POI result : results) {
      System.out.println(result);
    }
  }

}
