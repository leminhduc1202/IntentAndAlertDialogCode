package mdideas.devapp.intentandalertdialog


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mdideas.devapp.intentandalertdialog.databinding.ActivityClickBackBinding

class ActivityClickBack : AppCompatActivity() {

    lateinit var binding: ActivityClickBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClickback.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}