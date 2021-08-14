package mdideas.devapp.intentandalertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import mdideas.devapp.intentandalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //change activity layout
        binding.buttonClickme.setOnClickListener {
            val intent01 = Intent(this,ActivityClickBack::class.java)
            startActivity(intent01)
        }
        // add button alert dialog 01
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr.D to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _ , _ ->
                Toast.makeText(this," Your added Mr.D to your contact list", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _ , _ ->
                Toast.makeText(this," Your didn't add Mr.D to your contact list", Toast.LENGTH_LONG).show()
            }
            .create()
        binding.alertDialog1.setOnClickListener {
            addContactDialog.show()
        }
        // add button alert dialog 02
        val option = arrayOf("First Item", "Second Item","Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(option,0){dialogInterface, i ->
                Toast.makeText(this,"You clicked on ${option[i]}", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Accept"){ _ , _ ->
                Toast.makeText(this," You accepted this SingleChoiceDialog", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _ , _ ->
                Toast.makeText(this," You decline this SingleChoiceDialog", Toast.LENGTH_LONG).show()
            }
            .create()
        binding.alertDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }
        // add button alert dialog 03
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(option, booleanArrayOf(false, false, false)){_, i, isChecked ->
                if (isChecked){
                    Toast.makeText(this,"You checked ${option[i]}", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(this,"You unchecked ${option[i]}", Toast.LENGTH_LONG).show()
                }
            }
            .setPositiveButton("Accept"){ _ , _ ->
                Toast.makeText(this," You accepted this MultiChoiceDialog", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _ , _ ->
                Toast.makeText(this," You decline this MultiChoiceDialog", Toast.LENGTH_LONG).show()
            }
            .create()
        binding.alertDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}