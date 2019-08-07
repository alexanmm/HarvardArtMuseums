package br.com.digitalhouse.harvardartmuseums.model.userdata;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public class UserData {

    private static FirebaseUser user;
    private static Language language;

    public UserData() {
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser user) {
        this.user = user;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        UserData.language = language;
    }

    public void atualizaFavoritosUsuario(Context context, Object objectFavorites) {

        /*FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {

            if (objectFavorites.getLoginUser() == null) {
                objectFavorites.setLoginUser("");
            }

            dao.deleteByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());
            dao.insert(new Favorites(objectFavorites));

        }).start();
        */

        //Atualiza favoritos do usuário no Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios");

        usuarioReference
                .child(getUser().getUid())
                .child("favoritos")
                .child(objectFavorites.getObjectid().toString())
                .setValue(new Favorites(objectFavorites));

    }

    public void removeFavoritosUsuario(Context context, Object objectFavorites) {

        /*
        FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {
            dao.deleteByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());
        }).start();
        */

        //Instancia do firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        //Referencia
        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios").child(getUser().getUid());
        DatabaseReference objectReference = usuarioReference.child("favoritos").child(objectFavorites.getObjectid().toString());

        //Adicionamos o listener para buscar o objeto gravado em favoritos
        objectReference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Object objectLocal = dataSnapshot.getValue(Object.class);

                //Somente excluir a obra de favoritos se não houver classificação de estrelas
                if (objectLocal.getCountStarsFavorites() == 0) {

                    //Remove o registro da tabela
                    objectReference.removeValue();

                } else { //Somente atualizar o flag de favoritos como "falso"
                    objectLocal.setFavorite(false);

                    //Atualiza o registro na tabela
                    objectReference.setValue(objectLocal);
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void gravaIdiomaUsuario(int idIdioma, String textoIdioma) {

        Language languageLocal = new Language();

        languageLocal.setIdIdioma(idIdioma);
        languageLocal.setTextoIdioma(textoIdioma);

        language = languageLocal;

        //Atualiza favoritos do usuário no Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios");
        DatabaseReference idiomaReference = usuarioReference.child(getUser().getUid()).child("idioma");

        idiomaReference.setValue(language);

    }

    public void inicializaDados() {

        //Instancia do firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        //Referencia
        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios").child(getUser().getUid());
        DatabaseReference idiomaReference = usuarioReference.child(getUser().getUid()).child("idioma");

        //Adicionamos o listener para buscar o objeto gravado em favoritos
        idiomaReference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Language languageLocal = new Language();

                languageLocal = dataSnapshot.getValue(Language.class);

                language = languageLocal;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
