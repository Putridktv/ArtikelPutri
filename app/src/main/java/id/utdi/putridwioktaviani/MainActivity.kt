package id.utdi.putridwioktaviani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.utdi.putridwioktaviani.ui.theme.ArtikelPutriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikelPutriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage("Belajar Kotlin Jetpack Compose", "Yogyakarta")
                }
            }
        }
    }
}

@Composable //function untuk membuat bagian artikel mulai dari judul artikel hingga isi teks
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column( //menggunakan column agar susunan dapat rapi berurut dri atas kebawah
        verticalArrangement = Arrangement.Top, //untuk memposisikan tampilan mulai dari atas
        modifier = modifier
            .fillMaxSize()
            .padding(start = 10.dp)
    ) {
        Text( //teks untuk judul artikel
            text = message, //parameter untuk teks judul artikel
            fontSize = 24.sp, //ukran teks/
            fontWeight = FontWeight.Bold, //menebalkan teks
            lineHeight = 50.sp, //mengatur jarak antar line
            style = MaterialTheme.typography.headlineMedium, //mengatur typography headline/judul artikel
        )
        Row( verticalAlignment = Alignment.CenterVertically) {//menggunakan row untuk mensejajarkan icon lokasi dengan teks lokasi
            Image(
                //untuk menambahkan gambar icon lokasi dengan nama file "lokasi"
                painter = painterResource(R.drawable.lokasi),
                contentDescription = "location icon",
                modifier = Modifier
                    // Set ukuran gambar menjadi 15 dp
                    .size(15.dp)
            )
            Text(
                text = from, //parameter untuk teks lokasi
                fontSize = 15.sp, //ukuran teks
                modifier = Modifier
                    .padding(8.dp) //padding teks lokasi
            )
        }
        Image(
            //untuk menambahkan gambar dengan nama file "profpic"
            painter = painterResource(R.drawable.picture_artikel_1),
            contentDescription = "artikel 1",
            modifier = Modifier
                // Set ukuran gambar menjadi 40 dp
                .fillMaxWidth()
//                .border(4.dp, MaterialTheme.colorScheme.secondary)
        )

        Text( //teks untuk isi artikel
            text = "Jetpack Compose adalah android modern toolkit untuk membuat native UI. Jika biasanya kita membuat layout pada file xml, dengan tool ini nantinya kita akan membuat layout tersebut langsung di file kotlin. Tool ini memanfaatkan sifat UI declarative, jadi kita akan dipermudah dalam pembuatan UI, apalagi untuk UI custom yang effortnya cukup besar. Penulisan codenya memiliki kemiripan dengan Flutter, karena sama-sama memiliki sifat UI declarative.",
            fontSize = 15.sp, //ukuran teks
            textAlign = TextAlign.Justify, //meratakan tulisan
            style = MaterialTheme.typography.bodySmall, //mengatur typography isi konten artikel
            modifier = Modifier
                .padding(8.dp) //padding teks
        )
    }
}

@Composable
fun UserCard(modifier: Modifier = Modifier){ //function untuk bagain informasi penulis artikel
    Row( //menggunakan row agar gambar dan teks dapa sejajar
        verticalAlignment = Alignment.CenterVertically, //untuk men-centerkan antara teks dengan gambar
        modifier = Modifier
            .padding(10.dp)
    ) {
        Box {//mengngunakan box agar mudah mengatur posisi gambar profile picture dengan icon centang yang dapat diibaratkan digabungkan dalam satu area
            Image(
                //untuk menambahkan gambar dengan nama file "profpic"
                painter = painterResource(R.drawable.profpic),
                contentDescription = "Profile picture",
                modifier = Modifier
                    // Set ukuran gambar menjadi 50 dp
                    .size(50.dp)
                    // set gambar dari kotak menjadi lingkaran
                    .clip(CircleShape)
                //menambahkan desain material
//                .border(1.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
            Icon(
                painter = painterResource(R.drawable.centang), //menambahkan gambar icon dengan nama file "centang"
                contentDescription = null,
                modifier = Modifier
                    .size(15.dp)
                    .align(Alignment.BottomEnd)
            )
        }

        Spacer(modifier = Modifier.width(8.dp)) //menambahkan jarak antara gambar dengan teks

        Column {//mengguakan kolon agarr tulisan nama dan tanggal dapat rapi berurut kebawah
            Text(
                text = "Putri Dwi Oktaviani",
                fontWeight = FontWeight.Bold //menebalkan tulisan

            )

            Spacer(modifier = Modifier.width(10.dp)) //menambahkan jarak antar teks nama dan tanggal

            Text(
                text = "29 Sept 2023",
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) { //function untuk menggabungkan/ menyusun tiap komponen compose ke dalam satu halaman
    val image = painterResource(R.drawable.androidparty) //variabel image yang berfungsi memanggil gambar androidparty
    Box{//menggunakan box agar dapar dengan mudah mengatur posisisi antar komponen yang digabungkan dalam satu area
        Image( //untuk mengatur gambar dalam variabel image menjadi background halaman
            painter = image, //memanggil gambr dalam variabel image
            contentDescription = null,
            contentScale = ContentScale.Crop, //untuk mengatur ukuran gambar yang disesuaikan dengan ukuran layar
            alpha = 0.2F //untuk mentransparkan gambar
        )
        Column( //menggunakan column agar penyususan komponen dapat rapi berurut dari atas ke bawah
            modifier = Modifier
//                .paddingT
        ){
            header() //memanggil function header

            UserCard() //memanggil funciton UserCard

            GreetingText( //memanggil function GreetingText
                message =  message,
                from = from,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .align(alignment = Alignment.Start)
            )
        }
    }
}

@Composable
fun header(){ //function untuk  header halaman
    Row( //menggunakan row gar gambar icon back dapat sejajar dengan teks Artikel
        verticalAlignment = Alignment.CenterVertically, //agar gambar dan teks dapat sejajar dengan pas tengah
        modifier = Modifier
            .padding(10.dp)
    ) {
        Image(
            //untuk menambahkan gambar dengan nama file "back"
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                // Set ukuran gambar menjadi 30 dp
                .size(30.dp)
        )

        Spacer(modifier = Modifier.width(10.dp)) //menambahkan jarak antar gambar dengan teks agar tidak terlalu dekat

        Text(
            text = "Artikel",
            fontSize = 20.sp //mengatur ukuran font
        )
    }
}

//function preview dari compose tanpa harus mem-build dan menginstal aplikasi ke perangkat Android atau emulator
@Preview(showBackground = true)
@Composable
fun GreetingPreview() { //preview function greetingImage
    ArtikelPutriTheme {
        GreetingImage("Belajar Kotlin Jetpack Compose", "Yogyakarta")
    }
}

//fun usercardPreview(){ //preview function UserCard
//    BirthdayCardPutriTheme {
//        UserCard()
//    }
//}