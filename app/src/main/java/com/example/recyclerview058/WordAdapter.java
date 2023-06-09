package com.example.recyclerview058;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview058.databinding.WordItemListBinding;

import java.util.List;



/*****************3.- EXTIENDO LA CLASE WORDADATER QUE CONTIENE LA CLASE INTERNA WORDVIEWHOLER***********************/
public class WordAdapter  extends  RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    /*****************1.- AÑADIR REPRESENTACIÓN DE LOS DATOS***********************/
    private List<String > mWordlist;


    //paso 7 crear constructor que reciba datos que se enviaran
    public WordAdapter(List<String>mWordlist){

        this.mWordlist= mWordlist;
    }

    //4 ESTE METODO INICIALIZA LAS VISTAS LAS INFLA
    // EN EL CONSTRUCTOR RECIBE UN OBJETO LE PASAMOS BINDING
    // INSTANCIAMOS VIEWBINDING PARA RETONAR NUESTRO VIEWHOLDER CON ESA DEPENDENCIA
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
   return  new WordViewHolder(mBinding);
    }
    // 5  RECIBE LOS DATOS ENVIADOS DESDE EL METODO QUE GENERA LOS DATOS Y LOS SETEA AL TEXVIEW
    // CREMOAS UNA VARIABLE DE REFERENCIA DE CONTENIDO DE EL LISTADO Y LO ASIGNAMOS AL ELEMENTO
    // VISUAL QUE VIENE DEL HOLDER

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String element = mWordlist.get(position);
        holder.textView.setText(element);
    }

    // 6 Este método lleva la cuenta de cuantos elementos hay en el listado
    @Override
    public int getItemCount() {

       return mWordlist.size();
    }


    /*****************2.Crear clase interna que se llama ViewHolder***********************/
    // INICIALIZAMO TEXVIEW QUE ES DENTRO DEL XML  Y LLAMAMOS MBINDING QUE ES DE LA CLASE XML QUE CONTIENE TEXVIEW
    // NOS PEDIRA IMPLEMENTAR SU CONSTRUCTOR DE LA SUPER CLASE
    // CAMBIAMOS EL ELEMENTO ANTERIOR Y REFERENCIAMOS A LA CLASE BINDING QUE REPRESENTA NUESTRO LAYOUT WORD ITEM LIST

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView= mBinding.textView;
        }
    }


}
