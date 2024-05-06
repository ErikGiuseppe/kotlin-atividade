package carreiras.com.github.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 
/*Essa classe atua como um adaptador que ira, fornecer para o recycleview,
* Os metodos que irao fazer a visualizacao e vincular os dados a visualizacao (ViewHolder)
*/
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    //Lista para o RecycleView
    private val items = mutableListOf<ItemModel>()

    //Adicionando item na lista
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        //Essa funcao avisa a recycle view que a lista foi atualizada
        //E entao muda a visualizacao na tela
        notifyDataSetChanged()
    }

    //Criando o ViewHolder
    //O view holder serve como um objeto fixador
    //Mas ainda nao vinculado aos dados especificos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //colocando os elementos na tela
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    //Funcao que retornar a quantidade de itens
    override fun getItemCount(): Int = items.size

    //Funcao para bindar a viewholder as dados especificos
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //definindo a os itens em cada posição
        val item = items[position]
        //Faz propriamente o bind
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Pega o textView
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        //Funcao que binda o nome do item no textView
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}