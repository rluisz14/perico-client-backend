USE [pericodb]
GO

/****** Object:  Table [Business].[Category]    Script Date: 08/10/2022 15:13:33 ******/

INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Sandwiches','Disfruta de varios las diferentes versiones de tu sandwich Favorito','20 - 30','https://i.pinimg.com/originals/71/7d/4b/717d4b7f0ae876056e2d8d2ca485e904.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Enchiladas','Disfruta de varios las diferentes variedades de enchilada','25 - 40','https://placeralplato.com/files/2016/08/Enchiladas-de-pollo.jpg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Salchipapas','Disfruta de varios las diferentes versiones de tu salchipapa Favorita','15 - 25','https://www.cardamomo.news/__export/1610225590581/sites/debate/img/2021/01/09/botana_con_salchichas_fxcil_y_rxpida_las_salchipapas_crop1610224808939.jpeg_1187729725.jpeg','A')
GO
INSERT INTO [Business].[Category]([categoryName],[categoryDescription],[categoryPriceRange],[categoryImageUrl],[categoryStatus]) VALUES('Combinados','Porqué no es suficiente con uno solo, necesitas probar más','40 - 50','https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg','A')
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
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Solo una mordida','Disfruta de varios las diferentes versiones de tu sandwich Favorito',23.00,12.00,100,CURRENT_TIMESTAMP,'https://t2.rg.ltmcdn.com/es/posts/3/5/5/sandwich_americano_con_huevo_55553_orig.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Para nosotros','Para refrescar y seguir degustando',30.00,15.00,100,CURRENT_TIMESTAMP,'https://www.goya.com/media/4217/muffaletta-sandwich.jpg?quality=80','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Doble Torre','Nunca es una opción incorrecta',30.00,18.00,100,CURRENT_TIMESTAMP,'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/2019-08/classic-sandwich-bread.jpg?itok=ZA2g6TUf','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Tentación','Para calmar las ganas',30.00,18.00,100,CURRENT_TIMESTAMP,'https://i.ytimg.com/vi/ZGpxea1w3fE/maxresdefault.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Triple','Todas las variades, para todos los gustos',20.00,10.00,100,CURRENT_TIMESTAMP,'https://placeralplato.com/files/2015/05/Receta-de-sndwiches-de-miga-640x480.jpg?width=1200&enable=upscale','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Sandwiches'),'Para mi','Me lo merezco',24.00,10.00,100,CURRENT_TIMESTAMP,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Combinados'),'Invita pe','Disfruta de la mejor combinación de pan y papas',40.00,20.00,100,CURRENT_TIMESTAMP,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190322-ham-sandwich-horizontal-1553721016.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Combinados'),'Para ti','Porqué no es suficiente con uno solo, necesitas probar más',40.00,20.00,100,CURRENT_TIMESTAMP,'https://st4.depositphotos.com/1000605/21090/i/450/depositphotos_210905248-stock-photo-club-sandwich-ham-cheese.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Estación'),'Yo mismo soy','Disfruta de nuestro productos por temporada',30.00,18.00,100,CURRENT_TIMESTAMP,'https://i.ytimg.com/vi/RBXq7ySBLG0/maxresdefault.jpg','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Gaseosas'),'Inca Kola','Sabor original',5.00,3.00,100,CURRENT_TIMESTAMP,'https://riquezaperuana.despliegueweb.website/wp-content/uploads/2021/05/Diseno-sin-titulo-9.png','A')
GO
INSERT INTO [Business].[Product]([categoryId],[productName],[productDescription],[productPrice],[productCost],[productStock],[productRegisterDate],[productImageUrl],[productStatus]) VALUES((SELECT categoryId FROM [Business].[Category] WHERE [categoryName] = 'Cervezas'),'Cusqueña de Trigo','Cerveza Cusqueña Trigo Premium Bier',10.00,7.00,100,CURRENT_TIMESTAMP,'https://swissbrothers.com/1594-large_default/cerveza-de-trigo-cuzquena-49-33cl.jpg','A')
GO

/****** Object:  Table [Business].[Person]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Person]([personName],[personLastName],[personPhoneNumber],[personAddresss],[personAddresssReference],[personBirthday]) VALUES('CARLA','GONZALES','992185444','Av Las Rosas 152','Cerca al parque los girasoles','19/11/1990')
GO
INSERT INTO [Business].[Person]([personName],[personLastName],[personPhoneNumber],[personAddresss],[personAddresssReference],[personBirthday]) VALUES('LUIS','CORRALES','992185123','Av El Sol 144','Cruce con Av Tres','02/04/1990')
GO

/****** Object:  Table [Business].[User]    Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[User]([personId],[userName],[userPassword,[userType],[userCreationDate],[userStatus]) VALUES((SELECT personId FROM [Business].[Person] WHERE personName = 'CARLA' AND personLastName = 'GONZALES'),'cgonzales','cg123','CLIENT',CURRENT_TIMESTAMP,'A')
GO

INSERT INTO [Business].[User]([personId],[userName],[userPassword,[userType],[userCreationDate],[userStatus]) VALUES((SELECT personId FROM [Business].[Person] WHERE personName = 'LUIS' AND personLastName = 'CORRALES'),'lcorrales','lc123','EMPLOYEE',CURRENT_TIMESTAMP,'A')
GO

/****** Object:  Table [Business].[Offer]   Script Date: 08/10/2022 15:13:33 ******/
INSERT INTO [Business].[Offer]([offerPercentage],[offerDescription]) VALUES(10.00,'10% de descuento en combinados')
GO

