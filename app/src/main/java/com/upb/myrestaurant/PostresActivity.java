package com.upb.myrestaurant;

import android.app.ListActivity;
import android.os.Bundle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostresActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;
        private Integer imagenProducto;
    }

    private PostresActivity.MyAdapter adaptador = null;
    private static ArrayList<Producto> arregloProductos = new ArrayList<PostresActivity.Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new PostresActivity.MyAdapter(this);
        setListAdapter(adaptador);


        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_producto);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        //});
    }

    private void setData(){
        arregloProductos.clear();

        //Postre 1
        PostresActivity.Producto PostreActual1 = new PostresActivity.Producto();
        PostreActual1.nombreProducto = this.getResources().getString(R.string.Postre2);
        PostreActual1.ingredientesProducto = this.getResources().getString(R.string.ING_Postre1);
        PostreActual1.precioProducto = this.getResources().getString(R.string.PRECIO_Postre2);
        PostreActual1.imagenProducto = R.drawable.chees;
        arregloProductos.add(PostreActual1);

        //Postre 2
        PostresActivity.Producto PostreActual2 = new PostresActivity.Producto();
        PostreActual2.nombreProducto = this.getResources().getString(R.string.Postre1);
        PostreActual2.ingredientesProducto = this.getResources().getString(R.string.ING_Postre2);
        PostreActual2.precioProducto = this.getResources().getString(R.string.PRECIO_Postre1);
        PostreActual2.imagenProducto = R.drawable.tiramisu;
        arregloProductos.add(PostreActual2);

        //Postre 3
        PostresActivity.Producto PostreActual3 = new PostresActivity.Producto();
        PostreActual3.nombreProducto = this.getResources().getString(R.string.Postre3);
        PostreActual3.ingredientesProducto = this.getResources().getString(R.string.ING_Postre3);
        PostreActual3.precioProducto = this.getResources().getString(R.string.PRECIO_Postre3);
        PostreActual3.imagenProducto = R.drawable.foacnu;
        arregloProductos.add(PostreActual3);

    }

    public static class MyAdapter extends BaseAdapter {

        private Context myContexto;

        public MyAdapter (Context c){
            myContexto = c;
        }

        @Override
        public int getCount(){
            return arregloProductos.size();
        }

        @Override
        public Object getItem(int arg){
            return arregloProductos.get(arg);
        }

        @Override
        public long getItemId(int arg){
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;

            if (vista == null){
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_producto, null);
            }
            else {
                view = vista;
            }

            ImageView imgProducto = (ImageView) view.findViewById(R.id.imageViewProducto);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProductos.get(position).imagenProducto));

            TextView nombrePorducto = (TextView) view.findViewById(R.id.textViewNombreProducto);
            nombrePorducto.setText(arregloProductos.get(position).nombreProducto);

            TextView ingredientesPorducto = (TextView) view.findViewById(R.id.textViewIngredientes);
            ingredientesPorducto.setText(arregloProductos.get(position).ingredientesProducto);

            TextView precioPorducto = (TextView) view.findViewById(R.id.textViewPrecioProducto);
            precioPorducto.setText(arregloProductos.get(position).precioProducto);


            return view;
        }

    }


}