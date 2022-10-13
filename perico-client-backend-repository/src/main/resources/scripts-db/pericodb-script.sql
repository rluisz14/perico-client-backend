CREATE DATABASE [pericodb];
GO

USE [pericodb]
GO

CREATE SCHEMA [Business]
GO

/****** Object:  Table [Business].[Category]    Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[Category](
	[categoryId] [bigint] IDENTITY(1,1) NOT NULL,
	[categoryName] [nvarchar](200) NOT NULL,
	[categoryDescription] [nvarchar](200) NOT NULL,
	[categoryPriceRange] [nvarchar](50) NOT NULL,
	[categoryImageUrl] [nvarchar](200) NOT NULL,
	[categoryStatus] [nchar](1) NOT NULL
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [Business].[Product]    Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[Product](
	[productId] [bigint] IDENTITY(1,1) NOT NULL,
	[categoryId] [bigint] NULL,
	[productName] [nvarchar](200) NOT NULL,
	[productDescription] [nvarchar](200) NOT NULL,
	[productPrice] [decimal](8,2) NOT NULL,
	[productCost] [decimal](8,2) NOT NULL,
	[productStock] int NOT NULL,
	[productRegisterDate] [datetime] NOT NULL,
	[productImageUrl] [nvarchar](200) NOT NULL,
	[productStatus] [nchar](1) NOT NULL
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [Business].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([categoryId])
REFERENCES [Business].[Category] ([categoryId])
GO

/****** Object:  Table [Business].[Person]    Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[Person](
	[personId] [bigint] IDENTITY(1,1) NOT NULL,
	[personDocument] [nvarchar](8) NULL,
	[personName] [nvarchar](200) NOT NULL,
	[personLastName] [nvarchar](200) NOT NULL,
	[personPhoneNumber] [nvarchar](20) NULL,
	[personAddresss] [nvarchar](200) NULL,
	[personAddresssReference] [nvarchar](200) NULL,
	[personBirthday] [nvarchar](20) NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[personId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [Business].[User]    Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[User](
	[userId] [bigint] IDENTITY(1,1) NOT NULL,
	[personId] [bigint] NULL,
	[userName] [nvarchar](200) NOT NULL,
	[userPassword] [nvarchar](200) NOT NULL,
	[userType] [nvarchar](200) NOT NULL,
	[userCreationDate] [datetime] NOT NULL,
	[userStatus] [nchar](1) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [Business].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Person] FOREIGN KEY([personId])
REFERENCES [Business].[Person] ([personId])
GO

/****** Object:  Table [Business].[Discount]   Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[Discount](
	[discountId] [bigint] IDENTITY(1,1) NOT NULL,
	[categoryId] [bigint] NOT NULL,
	[discountPercentage] [decimal](8,2) NOT NULL,
	[discountDescription] [nvarchar](200) NOT NULL
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[discountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [Business].[Discount]  WITH CHECK ADD  CONSTRAINT [FK_Discount_Category] FOREIGN KEY([categoryId])
REFERENCES [Business].[Category] ([categoryId])
GO

/****** Object:  Table [Business].[Order]   Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[Order](
	[orderId] [bigint] IDENTITY(1,1) NOT NULL,
	[employeeUserId] [bigint] NULL,
	[clientUserId] [bigint] NULL,
	[orderDate] [datetime] NOT NULL,
	[orderDeliveredDate] [datetime] NULL,
	[orderStatus] [nvarchar](200) NOT NULL,
	[subtotal] [decimal](8,2) NOT NULL,
	[igv] [decimal](8,2) NOT NULL,
	[deliveryCost] [decimal](8,2) NOT NULL,
	[total] [decimal](8,2) NOT NULL,
	[phoneNumber] [nvarchar](20) NULL,
	[email] [nvarchar](200) NULL,
	[paymentMethod] [nvarchar](200) NOT NULL,
	[addressDelivery] [nvarchar](200) NOT NULL,
	[addressReferenceDelivery] [nvarchar](200) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [Business].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Employee] FOREIGN KEY([employeeUserId])
REFERENCES [Business].[User] ([userId])
GO

ALTER TABLE [Business].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Client] FOREIGN KEY([clientUserId])
REFERENCES [Business].[User] ([userId])
GO

/****** Object:  Table [Business].[OrderDetail]  Script Date: 08/10/2022 15:13:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Business].[OrderDetail](
	[orderDetailId] [bigint] IDENTITY(1,1) NOT NULL,
	[orderId] [bigint] NULL,
	[productId] [bigint] NULL,
	[price] [decimal](8,2) NOT NULL,
	[quantity] int NOT NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[orderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [Business].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([productId])
REFERENCES [Business].[Product] ([productId])
GO

GO
ALTER TABLE [Business].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([orderId])
REFERENCES [Business].[Order] ([orderId])
GO
