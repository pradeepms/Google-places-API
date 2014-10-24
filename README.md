# Google-places-API

Google places android app, built using Google place API and Google Android map v2 which lists surrounding Restaurants, Malls, ATM etc..

#### Setup :
1. Register for Google Places API Access key. Follow the steps [here] (https://developers.google.com/places/documentation/). And get one yourself.
2. Since I'm using Map in this app, get Access key for Maps as well. Here is the [documentation] (https://developers.google.com/maps/documentation/android/).

Add your Google places Access key in MainActivity.java, and also update location values.
        
    https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=your_lat,your_long&radius=100000&sensor=true&key=your_google_places_server_key&types=
    
    
Add your Google map v2 key in the manifest.xml

    <meta-data
    android:name="com.google.android.maps.v2.API_KEY"
    android:value="google_map_key_here" />


#### Dependencies :
* Add [Action Bar Sherlock] (https://github.com/PradeepMS/ActionBarSherlock) library project.
* Add google play service lib.

### Screen shots :
![Alt text](http://pradeepms.do.am/GitHub-Images/placeUI.png "Main UI")
![Alt text](http://pradeepms.do.am/GitHub-Images/placeDetail.png "Detail UI")



