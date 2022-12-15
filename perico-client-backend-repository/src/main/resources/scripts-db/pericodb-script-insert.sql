USE [pericodb]
GO

/****** Object:  Table [Business].[Category]    Script Date: 08/10/2022 15:13:33 ******/

INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Sandwiches','Disfruta de varios las diferentes versiones de tu sandwich Favorito','20 - 30','https://i.pinimg.com/originals/71/7d/4b/717d4b7f0ae876056e2d8d2ca485e904.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Enchiladas','Disfruta de varios las diferentes variedades de enchilada','25 - 40','https://placeralplato.com/files/2016/08/Enchiladas-de-pollo.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Salchipapas','Disfruta de varios las diferentes versiones de tu salchipapa Favorita','15 - 25','https://www.cardamomo.news/__export/1610225590581/sites/debate/img/2021/01/09/botana_con_salchichas_fxcil_y_rxpida_las_salchipapas_crop1610224808939.jpeg_1187729725.jpeg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Combinados','Porque no es suficiente con uno solo, necesitas probar mós','40 - 50','https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Gaseosas','Para refrescar y seguir degustando','5 - 15','https://synergiaconsultoria.com/images/2019/04/15/18225.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Cervezas','Nunca es una opción incorrecta','10 - 30','https://i.blogs.es/ce0c05/cervezas-varias2/450_1000.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Cocteles','Todas las variades, para todos los gustos','20 - 60','https://okdiario.com/img/2016/05/21/recetas-cocteles-fruta-sin-alcohol-655x368.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Adicionales','Para calmar las ganas','20 - 50','http://4.bp.blogspot.com/-GHH61Z1Fn10/TzjS0UFoaVI/AAAAAAAAAgc/lZYTggT4Dew/w1200-h630-p-k-no-nu/299881_294342510588372_100000378759302_965055_1680279504_n.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Estación','Disfruta de nuestro productos por temporada','25 - 30','https://i0.wp.com/kronos365.com/wp-content/uploads/2022/07/ESTACION-34.jpg?fit=620%2C330&ssl=1','A')
GO


/****** Object:  Table [Business].[Product]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Solo una mordida','Disfruta de varios las diferentes versiones de tu sandwich Favorito',23.00,12.00,CURRENT_TIMESTAMP,'https://t2.rg.ltmcdn.com/es/posts/3/5/5/sandwich_americano_con_huevo_55553_orig.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Para nosotros','Para refrescar y seguir degustando',30.00,15.00,CURRENT_TIMESTAMP,'https://www.goya.com/media/4217/muffaletta-sandwich.jpg?quality=80','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Doble Torre','Nunca es una opción incorrecta',30.00,18.00,CURRENT_TIMESTAMP,'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/2019-08/classic-sandwich-bread.jpg?itok=ZA2g6TUf','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Tentación','Para calmar las ganas',30.00,18.00,CURRENT_TIMESTAMP,'https://i.ytimg.com/vi/ZGpxea1w3fE/maxresdefault.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Triple','Todas las variades, para todos los gustos',20.00,10.00,CURRENT_TIMESTAMP,'https://placeralplato.com/files/2015/05/Receta-de-sndwiches-de-miga-640x480.jpg?width=1200&enable=upscale','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Para mi','Me lo merezco',24.00,10.00,CURRENT_TIMESTAMP,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Invita pe','Disfruta de la mejor combinación de pan y papas',40.00,20.00,CURRENT_TIMESTAMP,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Para ti','Porque no es suficiente con uno solo, necesitas probar mós',40.00,20.00,CURRENT_TIMESTAMP,'https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Yo mismo soy','Disfruta de nuestro productos por temporada',30.00,18.00,CURRENT_TIMESTAMP,'https://i.ytimg.com/vi/RBXq7ySBLG0/maxresdefault.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Solo una mordida','Disfruta de varios las diferentes versiones de tu sandwich Favorito',23.00,12.00,CURRENT_TIMESTAMP,'https://static.fanpage.it/wp-content/uploads/sites/22/2022/05/Chicken-enchiladas-21.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Para nosotros','Para refrescar y seguir degustando',30.00,15.00,CURRENT_TIMESTAMP,'https://www.gourmet.cl/wp-content/uploads/2021/08/foto-istock-enchilada-tama%C3%B1o-web.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Doble Torre','Nunca es una opción incorrecta',30.00,18.00,CURRENT_TIMESTAMP,'https://images-gmi-pmc.edge-generalmills.com/0798b070-1f82-4fa2-91ea-17e8175e44e3.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Tentación','Para calmar las ganas',30.00,18.00,CURRENT_TIMESTAMP,'https://i.blogs.es/23068c/enchiladas-verdes-rellenas-de-queso-1-/1366_2000.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Triple','Todas las variades, para todos los gustos',20.00,10.00,CURRENT_TIMESTAMP,'https://www.vvsupremo.com/wp-content/uploads/2015/10/900X570_Enchiladas-Morelia-Style-With-Chorizo-And-Potatoes.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Para mi','Me lo merezco',24.00,10.00,CURRENT_TIMESTAMP,'https://images-gmi-pmc.edge-generalmills.com/0798b070-1f82-4fa2-91ea-17e8175e44e3.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Invita pe','Disfruta de la mejor combinación de pan y papas',40.00,20.00,CURRENT_TIMESTAMP,'https://bakeitwithlove.com/wp-content/uploads/2020/03/Shredded-Chicken-Enchiladas-lg-sq.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Para ti','Porque no es suficiente con uno solo, necesitas probar mós',40.00,20.00,CURRENT_TIMESTAMP,'https://t2.rg.ltmcdn.com/es/posts/6/7/1/enchiladas_de_pollo_en_salsa_44176_600.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),'Yo mismo soy','Disfruta de nuestro productos por temporada',30.00,18.00,CURRENT_TIMESTAMP,'https://img.taste.com.au/fIUpd81z/taste/2019/10/no-bake-enchiladas-155076-1.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Solo una mordida','Disfruta de varios las diferentes versiones de tu sandwich Favorito',23.00,12.00,CURRENT_TIMESTAMP,'https://img.freepik.com/fotos-premium/salchipapa-comida-callejera-tradicional-salchipapas-peru-salchichas-papas-fritas_492434-134.jpg?w=2000','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Para nosotros','Para refrescar y seguir degustando',30.00,15.00,CURRENT_TIMESTAMP,'https://e.rpp-noticias.io/large/2019/05/14/513851_789110.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Doble Torre','Nunca es una opción incorrecta',30.00,18.00,CURRENT_TIMESTAMP,'https://www.teleantioquia.co/wp-content/uploads/2022/03/Inicio-otra-version-del-Salchipapa-Fest.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Tentación','Para calmar las ganas',30.00,18.00,CURRENT_TIMESTAMP,'https://www.infobae.com/new-resizer/bepTL0cqB7OHyC9qfZhaZdZ1hsw=/1200x900/filters:format(webp):quality(85)//cloudfront-us-east-1.images.arcpublishing.com/infobae/ZSGVRYLP4RHOXD5KYOROMWGKQE.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Triple','Todas las variades, para todos los gustos',20.00,10.00,CURRENT_TIMESTAMP,'https://www.ytuqueplanes.com/imagenes/fotos/novedades/salchipapa-parrilla.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Para mi','Me lo merezco',24.00,10.00,CURRENT_TIMESTAMP,'https://i0.wp.com/tarasmulticulturaltable.com/wp-content/uploads/2016/07/Salchipapas-Peruvian-Sausages-and-Potatoes-3-of-3.jpg?resize=720%2C478&ssl=1','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Invita pe','Disfruta de la mejor combinación de pan y papas',40.00,20.00,CURRENT_TIMESTAMP,'https://img.freepik.com/premium-photo/typical-latin-america-salchipapa-sausages-with-fries-ketchup-mustard-mayo_123827-3622.jpg?w=2000','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Para ti','Porque no es suficiente con uno solo, necesitas probar mós',40.00,20.00,CURRENT_TIMESTAMP,'https://www.magacin247.com/wp-content/uploads/2021/11/salchipapa.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas'),'Yo mismo soy','Disfruta de nuestro productos por temporada',30.00,18.00,CURRENT_TIMESTAMP,'https://elpilon.com.co/wp-content/uploads/2021/09/c1325391-316e-4978-aa18-9931aaed7126.jpeg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Combinados'),'Invita pe','Disfruta de la mejor combinación de pan y papas',40.00,20.00,CURRENT_TIMESTAMP,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Combinados'),'Para ti','Porque no es suficiente con uno solo, necesitas probar mós',40.00,20.00,CURRENT_TIMESTAMP,'https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Estación'),'Yo mismo soy','Disfruta de nuestro productos por temporada',30.00,18.00,CURRENT_TIMESTAMP,'https://i.ytimg.com/vi/RBXq7ySBLG0/maxresdefault.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Gaseosas'),'Inca Kola','Sabor original',5.00,3.00,CURRENT_TIMESTAMP,'https://riquezaperuana.despliegueweb.website/wp-content/uploads/2021/05/Diseno-sin-titulo-9.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Cervezas'),'Cusqueña de Trigo','Cerveza Cusqueña Trigo Premium Bier',10.00,7.00,CURRENT_TIMESTAMP,'https://swissbrothers.com/1594-large_default/cerveza-de-trigo-cuzquena-49-33cl.jpg','A')
GO

/****** Object:  Table [Business].[Provider]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Verduras Carmen',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Coca cola S.A.C',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('San fernando',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Oregon Foods',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Huevos la calera',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Alacena',CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Provider]([providerName],[providerRegisterDate],[providerStatus]) VALUES('Braedt',CURRENT_TIMESTAMP,'A')
GO

/****** Object:  Table [Business].[Supply]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Tomate','Kg',4.80,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Cebolla','Kg',3.70,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Papa Blanca','Kg',6.00,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Papa amarilla','Kg',10.00,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Papa amarilla Tumbay','Kg',9.00,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Cebolla china','Kg',2.00,2.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen'),'Lechuga','Kg',8.00,20.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Coca cola S.A.C'),'Coca cola','Lt',4.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Coca cola S.A.C'),'Inka cola','Lt',4.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Coca cola S.A.C'),'Sprite','Lt',3.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Coca cola S.A.C'),'Fanta','Lt',3.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'San fernando'),'Pechuga de pollo','Kg',13.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'San fernando'),'Hamburguesa de carne','Kg',15.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'San fernando'),'Pechuga de pavo','Kg',11.00,40.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Braedt'),'Hot dog','Kg',17.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Huevos la calera'),'Huevo','Kg',9.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Oregon Foods'),'Hamburguesa de carne agnus','Kg',90.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena'),'Ketchup','Kg',15.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena'),'Mostaza','Kg',12.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena'),'Mayonesa','Kg',16.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena'),'Uchucuta','Kg',20.00,10.00,CURRENT_TIMESTAMP,'A')
GO
INSERT INTO [Business].[Supply]([providerId],[supplyName],[metricUnits],[supplyCost],[supplyStock],[supplyRegisterDate],[supplyStatus]) VALUES ((SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena'),'Tari','Kg',20.00,10.00,CURRENT_TIMESTAMP,'A')
GO

/****** Object:  Table [Business].[ProductDetail]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Solo una mordida' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Papa amarilla' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen')),0.25)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Solo una mordida' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Hot dog' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Braedt')),0.25)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Solo una mordida' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Cebolla china' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen')),0.02)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Solo una mordida' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Ketchup' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena')),0.10)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Solo una mordida' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Mayonesa' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena')),0.10)
GO

INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Tentación' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Papa amarilla Tumbay' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Verduras Carmen')),0.25)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Tentación' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Hot dog' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Braedt')),0.25)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Tentación' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Ketchup' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena')),0.10)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Tentación' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Mayonesa' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena')),0.10)
GO
INSERT INTO [Business].[ProductDetail]([productId],[supplyId],[quantity]) VALUES ((SELECT productId FROM [Business].[Product] WHERE [productName] = 'Tentación' AND [categoryId] = (SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Salchipapas')) , (SELECT [supplyId] FROM [Business].[Supply] WHERE [supplyName] = 'Mostaza' AND [providerId] = (SELECT [providerId] FROM [Business].[Provider] WHERE [providerName] = 'Alacena')),0.10)
GO

/****** Object:  Table [Business].[Person]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Person]([personDocument],[personName],[personPhoneNumber],[personEmail],[personAddresss],[personAddresssReference],[personBirthdate]) VALUES('41239874','CARLA GOMEZ','992185444','cgomez@gmail.com','Av Las Rosas 152','Cerca al parque los girasoles','19/11/1990')
GO
INSERT INTO [Business].[Person]([personDocument],[personName],[personPhoneNumber],[personEmail],[personAddresss],[personAddresssReference],[personBirthdate]) VALUES('41239875','LUIS ALVAREZ','992185123','lalvarez@gmail.com','Av El Sol 144','Cruce con Av Tres','02/04/1990')
GO

/****** Object:  Table [Business].[User]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[User]([personId],[userName],[userPassword],[userType],[userCreationDate],[userStatus]) VALUES((SELECT personId FROM [Business].[Person] WHERE personDocument='41239874'),'cgonzales','cg123','CLIENT',CURRENT_TIMESTAMP,'A')
GO

INSERT INTO [Business].[User]([personId],[userName],[userPassword],[userType],[userCreationDate],[userStatus]) VALUES((SELECT personId FROM [Business].[Person] WHERE personDocument='41239875'),'lcorrales','lc123','EMPLOYEE',CURRENT_TIMESTAMP,'A')
GO

/****** Object:  Table [Business].[Discount]   Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Discount]([categoryId],[discountPercentage],[discountDescription]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Enchiladas'),10.00,'10% de descuento en combinados')
GO

