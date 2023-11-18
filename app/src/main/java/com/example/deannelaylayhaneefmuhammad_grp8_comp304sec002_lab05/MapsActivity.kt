package com.example.deannelaylayhaneefmuhammad_grp8_comp304sec002_lab05

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deannelaylayhaneefmuhammad_grp8_comp304sec002_lab05.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var landmark : String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landmark = intent.getStringExtra("selectedLandmark")

        if (landmark != null) {
            Log.d("SELECTEDLANDMARK", this.landmark!!)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_normal -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL;
                Toast.makeText(this, "Switched to Normal view", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_hybrid ->{
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID;
                Toast.makeText(this, "Switched to Hybrid view", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_satellite ->{
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE;
                Toast.makeText(this, "Switched to Satellite view", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_terrain ->{
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN;
                Toast.makeText(this, "Switched to Terrain view", Toast.LENGTH_SHORT).show()
            }

        }


        return true
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.setMaxZoomPreference(18.0f)
        mMap.setMinZoomPreference(10.0f)

        showLocation()
    }

    private fun showLocation() {

        var latLongInfo: DoubleArray = doubleArrayOf()
        when(landmark) {
            "CN Tower" -> {
                latLongInfo = doubleArrayOf(43.64263604726139, -79.38704607480089)
            }
            "Ripley's Aquarium of Canada" -> {
                latLongInfo = doubleArrayOf(43.642357044499306, -79.38630179623084)
            }
            "St. Lawrence Market" -> {
                latLongInfo = doubleArrayOf(43.648843135521304, -79.37155613247236)
            }
            "Canada's Wonderland" -> {
                latLongInfo = doubleArrayOf(43.84314758006409, -79.53947070362476)
            }
            "Art Gallery of Ontario (AGO)" -> {
                latLongInfo = doubleArrayOf(43.65375406023005, -79.39248011712834)
            }
            "Royal Ontario Museum (ROM)" -> {
                latLongInfo = doubleArrayOf(43.6679114508344, -79.39480929014314)
            }

            "The Aga Khan Museum" -> {
                latLongInfo = doubleArrayOf(43.725383877533496, -79.33213727294441)
            }
            "High Park" -> {
                latLongInfo = doubleArrayOf(43.64671090454008, -79.4637010324725)
            }
            "Toronto Islands" -> {
                latLongInfo = doubleArrayOf(43.620560,-79.376511)
            }
            "Scarborough Bluffs" -> {
                latLongInfo = doubleArrayOf(43.70623092681751, -79.23167033828933)
            }
            "Eaton Centre" -> {
                latLongInfo = doubleArrayOf(43.65468657019543, -79.38075304781574)
            }

            "Yorkdale" -> {
                latLongInfo = doubleArrayOf(43.72563655667778, -79.45214774595999)
            }
            "Kensington Market" -> {
                latLongInfo = doubleArrayOf(43.65531335558179, -79.40353029014382)
            }
        }
        mMap.addMarker(MarkerOptions().position(LatLng(latLongInfo[0], latLongInfo[1])).title(landmark))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latLongInfo[0], latLongInfo[1]), 17f))
        supportActionBar?.title = landmark
    }

}