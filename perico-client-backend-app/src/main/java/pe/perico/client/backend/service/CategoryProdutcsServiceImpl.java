package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryProdutcsServiceImpl implements CategoryProductsService {

    @Override
    public String getCategoryProductsLink() {
        return "{\n" +
                "  \"products\": [\n" +
                "    {\n" +
                "      \"indice\": \"1\",\n" +
                "      \"nombre\": \"Solo una mordida\",\n" +
                "      \"rangoPrecio\": \"20 - 30\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes versiones de tu sandwich Favorito\",\n" +
                "      \"imagenURL\": \"https://t2.rg.ltmcdn.com/es/posts/3/5/5/sandwich_americano_con_huevo_55553_orig.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"2\",\n" +
                "      \"nombre\": \"Invita pe\",\n" +
                "      \"rangoPrecio\": \"25 - 40\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes variedades de enchilada\",\n" +
                "      \"imagenURL\": \"https://t1.uc.ltmcdn.com/es/posts/2/4/8/como_preparar_un_sandwich_club_40842_orig.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"3\",\n" +
                "      \"nombre\": \"Para mi\",\n" +
                "      \"rangoPrecio\": \"15 - 25\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes versiones de tu salchipapa Favorita\",\n" +
                "      \"imagenURL\": \"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"4\",\n" +
                "      \"nombre\": \"Para ti\",\n" +
                "      \"rangoPrecio\": \"40 - 50\",\n" +
                "      \"descripcion\": \"Porqué no es suficiente con uno solo, necesitas probar más\",\n" +
                "      \"imagenURL\": \"https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"5\",\n" +
                "      \"nombre\": \"Para nosotros\",\n" +
                "      \"rangoPrecio\": \"5 - 15\",\n" +
                "      \"descripcion\": \"Para refrescar y seguir degustando\",\n" +
                "      \"imagenURL\": \"https://www.goya.com/media/4217/muffaletta-sandwich.jpg?quality=80\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"6\",\n" +
                "      \"nombre\": \"Doble Torre\",\n" +
                "      \"rangoPrecio\": \"10 - 30\",\n" +
                "      \"descripcion\": \"Nunca es una opción incorrecta\",\n" +
                "      \"imagenURL\": \"https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/2019-08/classic-sandwich-bread.jpg?itok=ZA2g6TUf\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"7\",\n" +
                "      \"nombre\": \"Triple\",\n" +
                "      \"rangoPrecio\": \"25 - 60\",\n" +
                "      \"descripcion\": \"Todas las variades, para todos los gustos\",\n" +
                "      \"imagenURL\": \"https://placeralplato.com/files/2015/05/Receta-de-sndwiches-de-miga-640x480.jpg?width=1200&enable=upscale\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"8\",\n" +
                "      \"nombre\": \"Tentación\",\n" +
                "      \"rangoPrecio\": \"20 - 50\",\n" +
                "      \"descripcion\": \"Para calmar las ganas\",\n" +
                "      \"imagenURL\": \"https://i.ytimg.com/vi/ZGpxea1w3fE/maxresdefault.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"9\",\n" +
                "      \"nombre\": \"Yo mismo soy\",\n" +
                "      \"rangoPrecio\": \"25 - 30\",\n" +
                "      \"descripcion\": \"Disfruta de nuestro productos por temporada\",\n" +
                "      \"imagenURL\": \"https://i.ytimg.com/vi/RBXq7ySBLG0/maxresdefault.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}
