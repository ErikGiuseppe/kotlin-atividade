package carreiras.com.github.listadecompras

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        //Criação da tela 
        super.onCreate(savedInstanceState)

        //usuando o R para pegar os atributos do xml
        setContentView(R.layout.activity_main)
        
        //Configurando o recyclerView para exibir uma lista de itens
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        
        //Instanciando ItemsAdapter
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        //De acordo com a documentação do Android, a Recycle View recicla os elementos individuais, então quando um item rola
        //para fora da tela, o item não é destruído da visualização dele em vez disso o RecyclerView reutiliza a visualização
        //para novos itens que possam a parecer na tela RecyclerView melhora o desempenho e a capacidade de resposta do app
        //além de reduzir o consumo de energia
        val button = findViewById<Button>(R.id.button)

        //usuando o R para pegar o Button pelo id definido na xml
        val editText = findViewById<EditText>(R.id.editText)

        //Usuando o R para pegar o EditText pelo id definido na xml
        //Definindo uma função para ser executada quando o botão for clicado
        button.setOnClickListener {
            //Colocando a respota do editText no name
            val item = ItemModel(
                name = editText.text.toString()
            )
            //adicionando na lista linkada com o recyclerView
            itemsAdapter.addItem(item)
        }
    }
}
