package pe.perico.client.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class OrdersCategoryServiceImpl implements OrdersCategoryService {

    @Override
    public String getOrdersCategoryLink() {
        return "{\n" +
                "  \"categories\": [\n" +
                "    {\n" +
                "      \"indice\": \"1\",\n" +
                "      \"nombre\": \"Sandwiches\",\n" +
                "      \"rangoPrecio\": \"20 - 30\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes versiones de tu sandwich Favorito\",\n" +
                "      \"imagenURL\": \"https://i.pinimg.com/originals/71/7d/4b/717d4b7f0ae876056e2d8d2ca485e904.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"2\",\n" +
                "      \"nombre\": \"Enchiladas\",\n" +
                "      \"rangoPrecio\": \"25 - 40\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes variedades de enchilada\",\n" +
                "      \"imagenURL\": \"https://placeralplato.com/files/2016/08/Enchiladas-de-pollo.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"3\",\n" +
                "      \"nombre\": \"Salchipapas\",\n" +
                "      \"rangoPrecio\": \"15 - 25\",\n" +
                "      \"descripcion\": \"Disfruta de varios las diferentes versiones de tu salchipapa Favorita\",\n" +
                "      \"imagenURL\": \"https://www.cardamomo.news/__export/1610225590581/sites/debate/img/2021/01/09/botana_con_salchichas_fxcil_y_rxpida_las_salchipapas_crop1610224808939.jpeg_1187729725.jpeg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"4\",\n" +
                "      \"nombre\": \"Combinados\",\n" +
                "      \"rangoPrecio\": \"40 - 50\",\n" +
                "      \"descripcion\": \"Porqué no es suficiente con uno solo, necesitas probar más\",\n" +
                "      \"imagenURL\": \"https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"5\",\n" +
                "      \"nombre\": \"Gaseosas\",\n" +
                "      \"rangoPrecio\": \"5 - 15\",\n" +
                "      \"descripcion\": \"Para refrescar y seguir degustando\",\n" +
                "      \"imagenURL\": \"https://synergiaconsultoria.com/images/2019/04/15/18225.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"6\",\n" +
                "      \"nombre\": \"Cervezas\",\n" +
                "      \"rangoPrecio\": \"10 - 30\",\n" +
                "      \"descripcion\": \"Nunca es una opción incorrecta\",\n" +
                "      \"imagenURL\": \"https://i.blogs.es/ce0c05/cervezas-varias2/450_1000.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"7\",\n" +
                "      \"nombre\": \"Cocteles\",\n" +
                "      \"rangoPrecio\": \"25 - 60\",\n" +
                "      \"descripcion\": \"Todas las variades, para todos los gustos\",\n" +
                "      \"imagenURL\": \"https://okdiario.com/img/2016/05/21/recetas-cocteles-fruta-sin-alcohol-655x368.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"8\",\n" +
                "      \"nombre\": \"Adicionales\",\n" +
                "      \"rangoPrecio\": \"20 - 50\",\n" +
                "      \"descripcion\": \"Para calmar las ganas\",\n" +
                "      \"imagenURL\": \"http://4.bp.blogspot.com/-GHH61Z1Fn10/TzjS0UFoaVI/AAAAAAAAAgc/lZYTggT4Dew/w1200-h630-p-k-no-nu/299881_294342510588372_100000378759302_965055_1680279504_n.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"indice\": \"9\",\n" +
                "      \"nombre\": \"Estación\",\n" +
                "      \"rangoPrecio\": \"25 - 30\",\n" +
                "      \"descripcion\": \"Disfruta de nuestro productos por temporada\",\n" +
                "      \"imagenURL\": \"https://i0.wp.com/kronos365.com/wp-content/uploads/2022/07/ESTACION-34.jpg?fit=620%2C330&ssl=1\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}
