package com.example.integratedagricultureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class SelectMandi extends AppCompatActivity {

    Spinner state,district,commodity;
    String txt1="1",txt2="2",txt3="3";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            ParseUser.logOut();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //    http://192.168.33.197:8000/mandiPriceApi/mandi-price-api/?comodity=Amaranthus&district=Thiruvananthapuram&format=json
    public void clickFun(View view){
        if(txt1=="1"||txt2=="2"||txt3=="3"||txt1=="Select Commodity"||txt2=="Select State"||txt3=="Select District")
            Toast.makeText(SelectMandi.this,"Please Select all options",Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(SelectMandi.this, txt1 + " " + txt2 + " " + txt3, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SelectMandi.this, MandiPrice.class);
            String url="http://192.168.33.197:8000/mandiPriceApi/mandi-price-api/?comodity="+txt1+"&district="+txt3+"&format=json";
            intent.putExtra("url",url);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mandi);
        setTitle("Select Mandi");
        commodity = findViewById(R.id.commodity);
        List<String> conList = new ArrayList<String>();
        conList.add("Select Commodity");
        conList.add("Ajwan");
        conList.add("Alasande Gram");
        conList.add("Almond(Badam)");
        conList.add("Alsandikai");
        conList.add("Amaranthus");
        conList.add("Ambada Seed");
        conList.add("Amla(Nelli Kai)");
        conList.add("Amphophalus");
        conList.add("Antawala");
        conList.add("Anthorium");
        conList.add("Apple");
        conList.add("Apricot(Jardalu/Khumani)");
        conList.add("Arecanut(Betelnut/Supari)");
        conList.add("Arhar (Tur/Red Gram)(Whole)");
        conList.add("Arhar Dal(Tur Dal)");
        conList.add("Ashgourd");
        conList.add("Astera");
        conList.add("Avare Dal");
        conList.add("Bajra(Pearl Millet/Cumbu)");
        conList.add("Balekai");
        conList.add("Bamboo");
        conList.add("Banana");
        conList.add("Banana - Green");
        conList.add("Barley (Jau)");
        conList.add("Bay leaf (Tejpatta)");
        conList.add("Beans");
        conList.add("Beaten Rice");
        conList.add("Beetroot");
        conList.add("Bengal Gram Dal (Chana Dal)");
        conList.add("Bengal Gram(Gram)(Whole)");
        conList.add("Ber(Zizyphus/Borehannu)");
        conList.add("Betal Leaves");
        conList.add("Betelnuts");
        conList.add("Bhindi(Ladies Finger)");
        conList.add("Big Gram");
        conList.add("Binoula");
        conList.add("Bitter gourd");
        conList.add("Black Gram (Urd Beans)(Whole)");
        conList.add("Black Gram Dal (Urd Dal)");
        conList.add("Black pepper");
        conList.add("BOP");
        conList.add("Borehannu");
        conList.add("Bottle gourd");
        conList.add("Bran");
        conList.add("Brinjal");
        conList.add("Broken Rice");
        conList.add("Broomstick(Flower Broom)");
        conList.add("Bull");
        conList.add("Bullar");
        conList.add("Bunch Beans");
        conList.add("Butter");
        conList.add("Cabbage");
        conList.add("Calf");
        conList.add("Camel Hair");
        conList.add("Cane");
        conList.add("Capsicum");
        conList.add("Cardamoms");
        conList.add("Carnation");
        conList.add("Carrot");
        conList.add("Cashew Kernnel");
        conList.add("Cashewnuts");
        conList.add("Cashewnuts");
        conList.add("Castor Oil");
        conList.add("Castor Seed");
        conList.add("Cauliflower");
        conList.add("Chakotha");
        conList.add("Chapparad Avare");
        conList.add("Chennangi (Whole)");
        conList.add("Chennangi Dal");
        conList.add("Cherry");
        conList.add("Chikoos(Sapota)");
        conList.add("Chili Red");
        conList.add("Chilly Capsicum");
        conList.add("Chow Chow");
        conList.add("Chrysanthemum");
        conList.add("Chrysanthemum(Loose)");
        conList.add("Cinamon(Dalchini)");
        conList.add("Cloves");
        conList.add("Cluster beans");
        conList.add("Coca");
        conList.add("Cock");
        conList.add("Cocoa");
        conList.add("Coconut");
        conList.add("Coconut");
        conList.add("Coconut Oil");
        conList.add("Coconut Seed");
        conList.add("Coffee");
        conList.add("Colacasia");
        conList.add("Copra");
        conList.add("Coriander(Leaves)");
        conList.add("Corriander seed");
        conList.add("Cotton");
        conList.add("Cotton Seed");
        conList.add("Cow");
        conList.add("Cowpea (Lobia/Karamani)");
        conList.add("Cowpea(Veg)");
        conList.add("Cucumbar(Kheera)");
        conList.add("Cummin Seed(Jeera)");
        conList.add("Custard Apple (Sharifa)");
        conList.add("Daila(Chandni)");
        conList.add("Dal (Avare)");
        conList.add("Dalda");
        conList.add("Delha");
        conList.add("Dhaincha");
        conList.add("Drumstick");
        conList.add("Dry Chillies");
        conList.add("Dry Fodder");
        conList.add("Dry Grapes");
        conList.add("Duck");
        conList.add("Duster Beans");
        conList.add("Egg");
        conList.add("Egypian Clover(Barseem)");
        conList.add("Elephant Yam (Suran)");
        conList.add("Field Pea");
        conList.add("Fig(Anjura/Anjeer)");
        conList.add("Firewood");
        conList.add("Fish");
        conList.add("Flower Broom");
        conList.add("Foxtail Millet(Navane)");
        conList.add("French Beans (Frasbean)");
        conList.add("Galgal(Lemon)");
        conList.add("Garlic");
        conList.add("Ghee");
        conList.add("Gingelly Oil");
        conList.add("Ginger(Dry)");
        conList.add("Ginger(Green)");
        conList.add("Gladiolus Bulb");
        conList.add("Gladiolus Cut Flower");
        conList.add("Goat");
        conList.add("Goat Hair");
        conList.add("Gram Raw(Chholia)");
        conList.add("Gramflour");
        conList.add("Grapes");
        conList.add("Green Avare (W)");
        conList.add("Green Chilli");
        conList.add("Green Fodder");
        conList.add("Green Gram (Moong)(Whole)");
        conList.add("Green Gram Dal (Moong Dal)");
        conList.add("Green Peas");
        conList.add("Ground Nut Oil");
        conList.add("Ground Nut `Seed");
        conList.add("Groundnut");
        conList.add("Groundnut (Split)");
        conList.add("Groundnut pods (raw)");
        conList.add("Guar");
        conList.add("Guar Seed(Cluster Beans Seed)");
        conList.add("Guava");
        conList.add("Gur(Jaggery)");
        conList.add("Gurellu");
        conList.add("Haralekai");
        conList.add("He Buffalo");
        conList.add("Hen");
        conList.add("Hippe Seed");
        conList.add("Honey");
        conList.add("Honge seed");
        conList.add("Hybrid Cumbu");
        conList.add("Indian Beans (Seam)");
        conList.add("Indian Colza(Sarson)");
        conList.add("Isabgul (Psyllium)");
        conList.add("Jack Fruit");
        conList.add("Jaffri");
        conList.add("Jaggery");
        conList.add("Jamamkhan");
        conList.add("Jamun(Narale Hannu)");
        conList.add("Jarbara");
        conList.add("Jasmine");
        conList.add("Javi");
        conList.add("Jowar(Sorghum)");
        conList.add("Jute");
        conList.add("Jute Seed");
        conList.add("Kabuli Chana(Chickpeas-White)");
        conList.add("Kacholam");
        conList.add("Kakada");
        conList.add("Kankambra");
        conList.add("Karamani");
        conList.add("Karbuja(Musk Melon)");
        conList.add("Kartali (Kantola)");
        conList.add("Kharif Mash");
        conList.add("Khoya");
        conList.add("Kinnow");
        conList.add("Knool Khol");
        conList.add("Kodo Millet(Varagu)");
        conList.add("Kuchur");
        conList.add("Kulthi(Horse Gram)");
        conList.add("Ladies Finger");
        conList.add("Lak(Teora)");
        conList.add("Leafy Vegetable");
        conList.add("Lemon");
        conList.add("Lentil (Masur)(Whole)");
        conList.add("Lilly");
        conList.add("Lime");
        conList.add("Linseed");
        conList.add("Lint");
        conList.add("Litchi");
        conList.add("Little gourd (Kundru)");
        conList.add("Long Melon(Kakri)");
        conList.add("Lotus");
        conList.add("Lotus Sticks");
        conList.add("Lukad");
        conList.add("Mace");
        conList.add("Mahedi");
        conList.add("Mahua");
        conList.add("Mahua Seed(Hippe seed)");
        conList.add("Maida Atta");
        conList.add("Maize");
        conList.add("Mango");
        conList.add("Mango (Raw-Ripe)");
        conList.add("Maragensu");
        conList.add("Marasebu");
        conList.add("Marget");
        conList.add("Marigold(Calcutta)");
        conList.add("Marigold(loose)");
        conList.add("Mash");
        conList.add("Mashrooms");
        conList.add("Masur Dal");
        conList.add("Mataki");
        conList.add("Methi Seeds");
        conList.add("Methi(Leaves)");
        conList.add("Millets");
        conList.add("Mint(Pudina)");
        conList.add("Moath Dal");
        conList.add("Moath Dal");
        conList.add("Mousambi(Sweet Lime)");
        conList.add("Mustard");
        conList.add("Mustard Oil");
        conList.add("Myrobolan(Harad)");
        conList.add("Nargasi");
        conList.add("Nearle Hannu");
        conList.add("Neem Seed");
        conList.add("Nelli Kai");
        conList.add("Niger Seed (Ramtil)");
        conList.add("Nutmeg");
        conList.add("Onion");
        conList.add("Onion Green");
        conList.add("Orange");
        conList.add("Orchid");
        conList.add("Other Pulses");
        conList.add("Ox");
        conList.add("Paddy(Dhan)(Basmati)");
        conList.add("Paddy(Dhan)(Common)");
        conList.add("Papaya");
        conList.add("Papaya (Raw)");
        conList.add("Patti Calcutta");
        conList.add("Peach");
        conList.add("Pear(Marasebu)");
        conList.add("Peas cod");
        conList.add("Peas Wet");
        conList.add("Peas(Dry)");
        conList.add("Pegeon Pea (Arhar Fali)");
        conList.add("Pepper garbled");
        conList.add("Pepper ungarbled");
        conList.add("Persimon(Japani Fal)");
        conList.add("Pigs");
        conList.add("Pineapple");
        conList.add("Plum");
        conList.add("Pointed gourd (Parval)");
        conList.add("Polherb");
        conList.add("Pomegranate");
        conList.add("Potato");
        conList.add("Pumpkin");
        conList.add("Pundi");
        conList.add("Pundi Seed");
        conList.add("Raddish");
        conList.add("Ragi (Finger Millet)");
        conList.add("Raibel");
        conList.add("Rajgir");
        conList.add("Ram");
        conList.add("Rat Tail Radish (Mogari)");
        conList.add("Raya");
        conList.add("Red Gram");
        conList.add("Resinwood");
        conList.add("Riccbcan");
        conList.add("Rice");
        conList.add("Ridgeguard(Tori)");
        conList.add("Rose(Local)");
        conList.add("Rose(Loose)");
        conList.add("Rose(Tata)");
        conList.add("Round gourd");
        conList.add("Rubber");
        conList.add("Sabu Dan");
        conList.add("Safflower");
        conList.add("Saffron");
        conList.add("Sajje");
        conList.add("Same/Savi");
        conList.add("Sarasum");
        conList.add("Season Leaves");
        conList.add("Seegu");
        conList.add("Seemebadnekai");
        conList.add("Seetapal");
        conList.add("Sesamum(Sesame,Gingelly,Til)");
        conList.add("She Buffalo");
        conList.add("She Goat");
        conList.add("Sheep");
        conList.add("Siddota");
        conList.add("Skin And Hide");
        conList.add("Snakeguard");
        conList.add("Soanf");
        conList.add("Soapnut(Antawala/Retha)");
        conList.add("Soji");
        conList.add("Sompu");
        conList.add("Soyabean");
        conList.add("Spinach");
        conList.add("Sponge gourd");
        conList.add("Squash(Chappal Kadoo)");
        conList.add("Sugar");
        conList.add("Sugarcane");
        conList.add("Sunflower");
        conList.add("Sunflower Seed");
        conList.add("Sunhemp");
        conList.add("Suram");
        conList.add("Surat Beans (Papadi)");
        conList.add("Suva (Dill Seed)");
        conList.add("Suvarna Gadde");
        conList.add("Sweet Potato");
        conList.add("Sweet Pumpkin");
        conList.add("T.V. Cumbu");
        conList.add("Tamarind Fruit");
        conList.add("Tamarind Seed");
        conList.add("Tapioca");
        conList.add("Taramira");
        conList.add("Tea");
        conList.add("Tender Coconut");
        conList.add("Thinai (Italian Millet)");
        conList.add("Thogrikai");
        conList.add("Thondekai");
        conList.add("Tinda");
        conList.add("Tobacco");
        conList.add("Tomato");
        conList.add("Torchwood");
        conList.add("Toria");
        conList.add("Tube Flower");
        conList.add("Tube Rose(Double)");
        conList.add("Tube Rose(Loose)");
        conList.add("Tube Rose(Single)");
        conList.add("Turmeric");
        conList.add("Turmeric (raw)");
        conList.add("Turnip");
        conList.add("Walnut");
        conList.add("Water Melon");
        conList.add("Wheat");
        conList.add("Wheat Atta");
        conList.add("White Peas");
        conList.add("White Pumpkin");
        conList.add("Wood");
        conList.add("Wool");
        conList.add("Yam");
        conList.add("Yam (Ratalu)");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, conList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        commodity.setAdapter(arrayAdapter);

        commodity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                txt1 = String.valueOf(commodity.getItemAtPosition(position));

                state = findViewById(R.id.state);
                List<String> list = new ArrayList<String>();
                list.add("Select State");
                list.add("Andaman and Nicobar");
                list.add("Andhra Pradesh");
                list.add("Arunachal Pradesh");
                list.add("Assam");
                list.add("Bihar");
                list.add("Chandigarh");
                list.add("Chattisgarh");
                list.add("Dadra and Nagar Haveli");
                list.add("Daman and Diu");
                list.add("Goa");
                list.add("Gujarat");
                list.add("Haryana");
                list.add("Himachal Pradesh");
                list.add("Jammu and Kashmir");
                list.add("Jharkhand");
                list.add("Karnataka");
                list.add("Kerala");
                list.add("Lakshadweep");
                list.add("Madhya Pradesh");
                list.add("Maharashtra");
                list.add("Manipur");
                list.add("Meghalaya");
                list.add("Mizoram");
                list.add("Nagaland");
                list.add("NCT of Delhi");
                list.add("Odisha");
                list.add("Pondicherry");
                list.add("Punjab");
                list.add("Rajasthan");
                list.add("Sikkim");
                list.add("Tamil Nadu");
                list.add("Telangana");
                list.add("Tripura");
                list.add("Uttar Pradesh");
                list.add("Uttrakhand");
                list.add("West Bengal");

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, list);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                state.setAdapter(arrayAdapter);


                state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        txt2 = String.valueOf(state.getItemAtPosition(position));
                        state.setSelection(position);

                        district = findViewById(R.id.district);
                        final List<String> distList = new ArrayList<String>();

                        distList.add("Select District");
                        if (position == 1) {
                            distList.add("Nicobar");
                            distList.add("North and Middle Andaman ");
                            distList.add("South Andaman");
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);

                        } else if (position == 2) {
                            distList.add("Anantapur");
                            distList.add("Chittor");
                            distList.add("Cuddapah");
                            distList.add("East Godavari");
                            distList.add("Guntur");
                            distList.add("Krishna");
                            distList.add("Kurnool");
                            distList.add("Nellore");
                            distList.add("Prakasam");
                            distList.add("Srikakulam");
                            distList.add("Vijayanagaram");
                            distList.add("Visakhapatnam");
                            distList.add("West Godavari");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 3) {
                            distList.add("Changlang");
                            distList.add("East Kameng");
                            distList.add("East Siang");
                            distList.add("Kurung Kummey");
                            distList.add("Lohit");
                            distList.add("Lower Dibang Valley");
                            distList.add("Lower Subansiri");
                            distList.add("Papum Pore");
                            distList.add("Tawang");
                            distList.add("Tirap");
                            distList.add("Upper Siang");
                            distList.add("Upper Subansiri");
                            distList.add("West Kameng");
                            distList.add("West Siang");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 4) {
                            distList.add("Bangaigaon");
                            distList.add("Barpeta");
                            distList.add("Cachar");
                            distList.add("Darrang");
                            distList.add("Dhemaji");
                            distList.add("Dhubri");
                            distList.add("Dibrugarh");
                            distList.add("Goalpara");
                            distList.add("Golaghat");
                            distList.add("Hailakandi");
                            distList.add("Jorhat");
                            distList.add("Kamrup");
                            distList.add("Karbi Anglong");
                            distList.add("Karimganj");
                            distList.add("Kokrajhar");
                            distList.add("Lakhimpur");
                            distList.add("Mangaldoi");
                            distList.add("Marigaon");
                            distList.add("Nagaon");
                            distList.add("Nalbari");
                            distList.add("North Cachar Hills");
                            distList.add("Sibsagar");
                            distList.add("Sonitpur");
                            distList.add("Tinsukia");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 5) {
                            distList.add("Araria");
                            distList.add("Aurangabad");
                            distList.add("Banka");
                            distList.add("Begusarai");
                            distList.add("Bhabhua");
                            distList.add("Bhagalpur");
                            distList.add("Bhojpur");
                            distList.add("Buxar");
                            distList.add("Chhapra");
                            distList.add("Darbhanga");
                            distList.add("Gaya");
                            distList.add("Gopalgang");
                            distList.add("Jamui");
                            distList.add("Jehanabad");
                            distList.add("Kaithar");
                            distList.add("Khagaria");
                            distList.add("Kishanganj");
                            distList.add("Luckeesarai");
                            distList.add("Madhepura");
                            distList.add("Madhubani");
                            distList.add("Munghair");
                            distList.add("Muzaffarpur");
                            distList.add("Nalanda");
                            distList.add("Nawada");
                            distList.add("Patna");
                            distList.add("Patna");
                            distList.add("Rohtas");
                            distList.add("Saharsa");
                            distList.add("Samastipur");
                            distList.add("Saran");
                            distList.add("Sheikhpura");
                            distList.add("Sitamarhi");
                            distList.add("Siwan");
                            distList.add("Supaul");
                            distList.add("Vaishali");
                            distList.add("West Chambaran");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 6) {
                            distList.add("Chandigarh");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 7) {
                            distList.add("Balod");
                            distList.add("Balodabazar");
                            distList.add("Balrampur");
                            distList.add("Bastar");
                            distList.add("Bemetara");
                            distList.add("Bijapur");
                            distList.add("Bilaspur");
                            distList.add("Dantewada");
                            distList.add("Dhamtari");
                            distList.add("Durg");
                            distList.add("Gariyaband");
                            distList.add("Jagdalpur");
                            distList.add("Janjgir");
                            distList.add("Jashpur");
                            distList.add("Kabirdham");
                            distList.add("Kanker");
                            distList.add("Kawardha");
                            distList.add("Kondagaon");
                            distList.add("Korba");
                            distList.add("Koria");
                            distList.add("Mahasamund");
                            distList.add("Mungeli");
                            distList.add("Narayanpur");
                            distList.add("North Bastar");
                            distList.add("Raigarh");
                            distList.add("Raipur");
                            distList.add("Rajnandgaon");
                            distList.add("Sukma");
                            distList.add("Surajpur");
                            distList.add("Surguja");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 8) {
                            distList.add("Dadra & Nagar Haveli");
                            distList.add("Silvassa");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 9) {
                            distList.add("Daman");
                            distList.add("Diu");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 10) {
                            distList.add("North Goa");
                            distList.add("South Goa");
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 11) {
                            distList.add("Ahmedabad");
                            distList.add("Amreli");
                            distList.add("Anand");
                            distList.add("Aravalli ");
                            distList.add("Banaskanth");
                            distList.add("Bharuch");
                            distList.add("Bhavnagar");
                            distList.add("Botad");
                            distList.add("Chhota Udaipur");
                            distList.add("Dahod");
                            distList.add("Dang");
                            distList.add("Devbhumi Dwarka");
                            distList.add("Gandhinagar");
                            distList.add("Gir Somnath");
                            distList.add("Jamnagar");
                            distList.add("Junagarh");
                            distList.add("Kachchh");
                            distList.add("Kheda");
                            distList.add("Mahisagar");
                            distList.add("Mehsana");
                            distList.add("Morbi");
                            distList.add("Narmada");
                            distList.add("Navsari");
                            distList.add("Panchmahals");
                            distList.add("Patan");
                            distList.add("Porbandar");
                            distList.add("Rajkot");
                            distList.add("Sabarkantha");
                            distList.add("Surat");
                            distList.add("Surendranagar");
                            distList.add("Tapi");
                            distList.add("The Dangs");
                            distList.add("Vadodara(Baroda)");
                            distList.add("Valsad");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 12) {
                            distList.add("Ambala");
                            distList.add("Bhiwani");
                            distList.add("Faridabad");
                            distList.add("Fatehabad");
                            distList.add("Gurgaon");
                            distList.add("Hissar");
                            distList.add("Jhajar");
                            distList.add("Jind");
                            distList.add("Kaithal");
                            distList.add("Karnal");
                            distList.add("Kurukshetra");
                            distList.add("Mahendragarh-Narnaul");
                            distList.add("Mewat");
                            distList.add("Palwal");
                            distList.add("Panchkula");
                            distList.add("Panipat");
                            distList.add("Rewari");
                            distList.add("Rohtak");
                            distList.add("Sirsa");
                            distList.add("Sonipat");
                            distList.add("Yamuna Nagar");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 13) {
                            distList.add("Bilaspur");
                            distList.add("Chamba");
                            distList.add("Hamirpur");
                            distList.add("Kangra");
                            distList.add("Kangra (at Dharmashala)");
                            distList.add("Kinnaur (at Kalpa)");
                            distList.add("Kullu");
                            distList.add("Lahul & Spiti");
                            distList.add("Mandi");
                            distList.add("Shimla");
                            distList.add("Sirmore");
                            distList.add("Solan");
                            distList.add("Una");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 14) {
                            distList.add("Akhnoor");
                            distList.add("Anantnag");
                            distList.add("Badgam");
                            distList.add("Baramulla");
                            distList.add("Doda");
                            distList.add("Handwara");
                            distList.add("Jammu");
                            distList.add("Kargil");
                            distList.add("Kathua");
                            distList.add("Kupwara");
                            distList.add("Leh");
                            distList.add("Poonch");
                            distList.add("Pulwama");
                            distList.add("Rajouri");
                            distList.add("Srinagar");
                            distList.add("Udhampur");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 15) {
                            distList.add("Bokaro");
                            distList.add("Chatra");
                            distList.add("Deogarh");
                            distList.add("Dhanbad");
                            distList.add("Dumka");
                            distList.add("East Singhbhum");
                            distList.add("Garhwa");
                            distList.add("Giridih");
                            distList.add("Godda");
                            distList.add("Gumla");
                            distList.add("Hazaribagh");
                            distList.add("Jamtara");
                            distList.add("Koderma");
                            distList.add("Latehar");
                            distList.add("Lohardaga");
                            distList.add("Pakur");
                            distList.add("Palamu");
                            distList.add("Ranchi");
                            distList.add("Sahebgang");
                            distList.add("Saraikela(Kharsanwa)");
                            distList.add("Simdega");
                            distList.add("West Singbhum");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 16) {
                            distList.add("Bagalkot");
                            distList.add("Bangalore");
                            distList.add("Belgaum");
                            distList.add("Bellary");
                            distList.add("Bidar");
                            distList.add("Bijapur");
                            distList.add("Chamrajnagar");
                            distList.add("Chikmagalur");
                            distList.add("Chitradurga");
                            distList.add("Davangere");
                            distList.add("Dharwad");
                            distList.add("Gadag");
                            distList.add("Gulbarga");
                            distList.add("Hassan");
                            distList.add("Haveri");
                            distList.add("Karwar(Uttar Kannad)");
                            distList.add("Kolar");
                            distList.add("Koppal");
                            distList.add("Madikeri(Kodagu)");
                            distList.add("Mandya");
                            distList.add("Mangalore(Dakshin Kannad)");
                            distList.add("Mysore");
                            distList.add("Raichur");
                            distList.add("Ramanagar");
                            distList.add("Shimoga");
                            distList.add("Tumkur");
                            distList.add("Udupi");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 17) {
                            distList.add("Alappuzha");
                            distList.add("Alleppey");
                            distList.add("Calicut");
                            distList.add("Ernakulam");
                            distList.add("Idukki");
                            distList.add("Kannur");
                            distList.add("Kasargod");
                            distList.add("Kollam");
                            distList.add("Kottayam");
                            distList.add("Kozhikode(Calicut)");
                            distList.add("Malappuram");
                            distList.add("Palakad");
                            distList.add("Pathanamthitta");
                            distList.add("Thirssur");
                            distList.add("Thiruvananthapuram");
                            distList.add("Wayanad");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 18) {
                            distList.add("Kavaratti");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 19) {
                            distList.add("Alirajpur");
                            distList.add("Anupur");
                            distList.add("Ashoknagar");
                            distList.add("Badwani");
                            distList.add("Balaghat");
                            distList.add("Betul");
                            distList.add("Bhind");
                            distList.add("Bhopal");
                            distList.add("Burhanpur");
                            distList.add("Chhatarpur");
                            distList.add("Chhindwara");
                            distList.add("Damoh");
                            distList.add("Datia");
                            distList.add("Dewas");
                            distList.add("Dhar");
                            distList.add("Dindori");
                            distList.add("Guna");
                            distList.add("Gwalior");
                            distList.add("Harda");
                            distList.add("Hoshangabad");
                            distList.add("Indore");
                            distList.add("Jabalpur");
                            distList.add("Jhabua");
                            distList.add("Katni");
                            distList.add("Khandwa");
                            distList.add("Khargone");
                            distList.add("Mandla");
                            distList.add("Mandsaur");
                            distList.add("Morena");
                            distList.add("Narsinghpur");
                            distList.add("Neemuch");
                            distList.add("Panna");
                            distList.add("Raisen");
                            distList.add("Rajgarh");
                            distList.add("Ratlam");
                            distList.add("Rewa");
                            distList.add("Sagar");
                            distList.add("Satna");
                            distList.add("Sehore");
                            distList.add("Seoni");
                            distList.add("Shajapur");
                            distList.add("Shehdol");
                            distList.add("Sheopur");
                            distList.add("Shivpuri");
                            distList.add("Sidhi");
                            distList.add("Singroli");
                            distList.add("Tikamgarh");
                            distList.add("Ujjain");
                            distList.add("Umariya");
                            distList.add("Vidisha");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 20) {
                            distList.add("Ahmednagar");
                            distList.add("Akola");
                            distList.add("Amarawati");
                            distList.add("Aurangabad");
                            distList.add("Bandra(E)");
                            distList.add("Beed");
                            distList.add("Bhandara");
                            distList.add("Buldhana");
                            distList.add("Chandrapur");
                            distList.add("Dharashiv(Usmanabad)");
                            distList.add("Dhule");
                            distList.add("Gadchiroli");
                            distList.add("Gondiya");
                            distList.add("Hingoli");
                            distList.add("Jalana");
                            distList.add("Jalgaon");
                            distList.add("Kolhapur");
                            distList.add("Latur");
                            distList.add("Mumbai");
                            distList.add("Nagpur");
                            distList.add("Nanded");
                            distList.add("Nandurbar");
                            distList.add("Nashik");
                            distList.add("Osmanabad");
                            distList.add("Parbhani");
                            distList.add("Pune");
                            distList.add("Raigad");
                            distList.add("Ratnagiri");
                            distList.add("Sangli");
                            distList.add("Satara");
                            distList.add("Sholapur");
                            distList.add("Sindhudurg");
                            distList.add("Thane");
                            distList.add("Vashim");
                            distList.add("Wardha");
                            distList.add("Yavatmal");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 21) {
                            distList.add("Bishnupur");
                            distList.add("Chandel");
                            distList.add("Churachandpur");
                            distList.add("Imphal East");
                            distList.add("Imphal West");
                            distList.add("Senapati");
                            distList.add("Tamenglong");
                            distList.add("Tengnoupal");
                            distList.add("Thoubal");
                            distList.add("Ukhrul");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 22) {
                            distList.add("East Garo Hills");
                            distList.add("East Jaintia Hills");
                            distList.add("East Khasi Hills");
                            distList.add("Nongpoh (R-Bhoi)");
                            distList.add("North Garo Hills");
                            distList.add("South Garo Hills");
                            distList.add("South West Garo Hills");
                            distList.add("South West Khasi Hills");
                            distList.add("West Garo Hills");
                            distList.add("West Jaintia Hills");
                            distList.add("West Khasi Hills");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 23) {
                            distList.add("Aizawl");
                            distList.add("Kolasib");
                            distList.add("Lungli");
                            distList.add("Mamit");
                            distList.add("Saiha");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 24) {
                            distList.add("Dimapur");
                            distList.add("Kiphire");
                            distList.add("Kohima");
                            distList.add("Longleng");
                            distList.add("Mokokchung");
                            distList.add("Mon");
                            distList.add("Peren");
                            distList.add("Phek");
                            distList.add("Tuensang");
                            distList.add("Wokha");
                            distList.add("Zunheboto");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 25) {
                            distList.add("Delhi");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 26) {
                            distList.add("Angul");
                            distList.add("Balasore");
                            distList.add("Bargarh");
                            distList.add("Berhampur");
                            distList.add("Bhadrak");
                            distList.add("Bhubaneswar");
                            distList.add("Bolangir");
                            distList.add("Boudh");
                            distList.add("Cuttack");
                            distList.add("Deogarh");
                            distList.add("Dhenkanal");
                            distList.add("Gajapati");
                            distList.add("Ganjam");
                            distList.add("Jagatsinghpur");
                            distList.add("Jajpur");
                            distList.add("Jharsuguda");
                            distList.add("Kalahandi");
                            distList.add("Kandhamal");
                            distList.add("Kendrapara");
                            distList.add("Keonjhar");
                            distList.add("Khurda");
                            distList.add("Koraput");
                            distList.add("Malkangiri");
                            distList.add("Mayurbhanja");
                            distList.add("Nayagarh");
                            distList.add("Nowarangpur");
                            distList.add("Nuapada");
                            distList.add("Puri");
                            distList.add("Rayagada");
                            distList.add("Rourkela");
                            distList.add("Sambalpur");
                            distList.add("Sonepur");
                            distList.add("Sundergarh");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 27) {
                            distList.add("Karaikal");
                            distList.add("Mahe");
                            distList.add("Pondicherry");
                            distList.add("Yanam");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 28) {
                            distList.add("Amritsar");
                            distList.add("Barnala");
                            distList.add("Bhatinda");
                            distList.add("Faridkot");
                            distList.add("Fatehgarh");
                            distList.add("Fazilka");
                            distList.add("Ferozpur");
                            distList.add("Gurdaspur");
                            distList.add("Hoshiarpur");
                            distList.add("Jalandhar");
                            distList.add("kapurthala");
                            distList.add("Ludhiana");
                            distList.add("Mansa");
                            distList.add("Moga");
                            distList.add("Mohali");
                            distList.add("Muktsar");
                            distList.add("Nawanshahr");
                            distList.add("Pathankot");
                            distList.add("Patiala");
                            distList.add("Ropar (Rupnagar)");
                            distList.add("Sangrur");
                            distList.add("Tarntaran");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 29) {
                            distList.add("Ajmer");
                            distList.add("Alwar");
                            distList.add("Banswara");
                            distList.add("Baran");
                            distList.add("Barmer");
                            distList.add("Bharatpur");
                            distList.add("Bhilwara");
                            distList.add("Bikaner");
                            distList.add("Bundi");
                            distList.add("Chittorgarh");
                            distList.add("Churu");
                            distList.add("Dausa");
                            distList.add("Dholpur");
                            distList.add("Dungarpur");
                            distList.add("Ganganagar");
                            distList.add("Hanumangarh");
                            distList.add("Jaipur");
                            distList.add("Jaisalmer");
                            distList.add("Jalore");
                            distList.add("Jhafarapatan");
                            distList.add("Jhalawar");
                            distList.add("Jhunjunu");
                            distList.add("Jodhpur");
                            distList.add("Karauli");
                            distList.add("Kota");
                            distList.add("Nagaur");
                            distList.add("Pali");
                            distList.add("Rajasamand");
                            distList.add("Sikar");
                            distList.add("Sirohi");
                            distList.add("Swai Madhopur");
                            distList.add("Tonk");
                            distList.add("Udaipur");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 30) {
                            distList.add("North Sikkim (Mangan)");
                            distList.add("South Sikkim (Namchi)");
                            distList.add("West Sikkim (Gyalsing)");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 31) {
                            distList.add("Ariyalur");
                            distList.add("Chennai");
                            distList.add("Coimbatore");
                            distList.add("Cuddalore");
                            distList.add("Dharmapuri");
                            distList.add("Dindigul");
                            distList.add("Erode");
                            distList.add("Kancheepuram");
                            distList.add("Karur");
                            distList.add("Krishnagiri");
                            distList.add("Madurai");
                            distList.add("Nagapattinam");
                            distList.add("Nagercoil (Kannyiakumari)");
                            distList.add("Namakkal");
                            distList.add("Perambalur");
                            distList.add("Pudukkottai");
                            distList.add("Ramanathapuram");
                            distList.add("Salem");
                            distList.add("Sivaganga");
                            distList.add("Thanjavur");
                            distList.add("The Nilgiris");
                            distList.add("Theni");
                            distList.add("Thiruchirappalli");
                            distList.add("Thirunelveli");
                            distList.add("Thiruvannamalai");
                            distList.add("Thiruvarur");
                            distList.add("Thiruvellore");
                            distList.add("Tuticorin");
                            distList.add("Vellore");
                            distList.add("Villupuram");
                            distList.add("Virudhunagar");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 32) {
                            distList.add("Adilabad");
                            distList.add("Hyderabad");
                            distList.add("Jagityal");
                            distList.add("Kamareddy");
                            distList.add("Karimnagar");
                            distList.add("Khammam");
                            distList.add("Mahbubnagar");
                            distList.add("Medak");
                            distList.add("Nalgonda");
                            distList.add("Nizamabad");
                            distList.add("Ranga Reddy");
                            distList.add("Siddipet");
                            distList.add("Warangal");


                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 33) {
                            distList.add("Dhalai");
                            distList.add("Gomati");
                            distList.add("Khowai");
                            distList.add("North Tripura");
                            distList.add("Sepahijala");
                            distList.add("South District");
                            distList.add("Unokoti");
                            distList.add("West District");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 34) {
                            distList.add("Agra");
                            distList.add("Aligarh");
                            distList.add("Allahabad");
                            distList.add("Ambedkarnagar");
                            distList.add("Auraiya");
                            distList.add("Azamgarh");
                            distList.add("Badaun");
                            distList.add("Baghpat");
                            distList.add("Bahraich");
                            distList.add("Ballia");
                            distList.add("Balrampur");
                            distList.add("Banda");
                            distList.add("Barabanki");
                            distList.add("Bareilly");
                            distList.add("Basti");
                            distList.add("Bhadohi(Sant Ravi Nagar)");
                            distList.add("Bijnor");
                            distList.add("Bulandshahar");
                            distList.add("Chandauli");
                            distList.add("Chitrakut");
                            distList.add("Deoria");
                            distList.add("Etah");
                            distList.add("Etawah");
                            distList.add("Faizabad");
                            distList.add("Farukhabad");
                            distList.add("Fatehpur");
                            distList.add("Firozabad");
                            distList.add("Gautam Budh Nagar");
                            distList.add("Ghaziabad");
                            distList.add("Ghazipur");
                            distList.add("Gonda");
                            distList.add("Gorakhpur");
                            distList.add("Hamirpur");
                            distList.add("Hardoi");
                            distList.add("Hathras");
                            distList.add("Jalaun (Orai)");
                            distList.add("Jaunpur");
                            distList.add("Jhansi");
                            distList.add("Jyotiba Phule Nagar");
                            distList.add("Kannuj");
                            distList.add("Kanpur");
                            distList.add("Kaushambi");
                            distList.add("Khiri (Lakhimpur)");
                            distList.add("Lakhimpur");
                            distList.add("Lalitpur");
                            distList.add("Lucknow");
                            distList.add("Maharajganj");
                            distList.add("Mahoba");
                            distList.add("Mainpuri");
                            distList.add("Mathura");
                            distList.add("Mau(Maunathbhanjan)");
                            distList.add("Meerut");
                            distList.add("Mirzapur");
                            distList.add("Muradabad");
                            distList.add("Muzaffarnagar");
                            distList.add("Oraya");
                            distList.add("Padrauna(Kusinagar)");
                            distList.add("Pillibhit");
                            distList.add("Pratapgarh");
                            distList.add("Raebarelli");
                            distList.add("Rampur");
                            distList.add("Saharanpur");
                            distList.add("Sant Kabir Nagar");
                            distList.add("Shahjahanpur");
                            distList.add("Shravasti");
                            distList.add("Siddharth Nagar");
                            distList.add("Sitapur");
                            distList.add("Sonbhadra");
                            distList.add("Sultanpur");
                            distList.add("Unnao");
                            distList.add("Varanasi");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 35) {
                            distList.add("Almora");
                            distList.add("Bageshwar");
                            distList.add("Chamoli (Gopeshwar)");
                            distList.add("Champawat");
                            distList.add("Dehradoon");
                            distList.add("Garhwal (Pauri)");
                            distList.add("Haldwani");
                            distList.add("Haridwar");
                            distList.add("Nanital");
                            distList.add("Pithoragarh");
                            distList.add("Rudraprayag");
                            distList.add("Tehri Garhwal");
                            distList.add("UdhamSinghNagar");
                            distList.add("Uttarkashi");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        } else if (position == 36) {
                            distList.add("Bankura");
                            distList.add("Birbhum");
                            distList.add("Burdwan");
                            distList.add("Coochbehar");
                            distList.add("Dakshin Dinajpur");
                            distList.add("Darjeeling");
                            distList.add("Hooghly");
                            distList.add("Howrah");
                            distList.add("Jalpaiguri");
                            distList.add("Kolkata");
                            distList.add("Malda");
                            distList.add("Medinipur(E)");
                            distList.add("Medinipur(W)");
                            distList.add("Murshidabad");
                            distList.add("Nadia");
                            distList.add("North 24 Parganas");
                            distList.add("Puruliya");
                            distList.add("Sounth 24 Parganas");
                            distList.add("Uttar Dinajpur");

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SelectMandi.this, android.R.layout.simple_spinner_item, distList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            district.setAdapter(arrayAdapter);
                        }

                        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                                txt3 = String.valueOf(district.getItemAtPosition(position));

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
