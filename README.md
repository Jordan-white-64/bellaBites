# Bella Bites — Restaurant Ordering System

A Java Swing desktop app for ordering from a fictional restaurant, with separate customer and staff views.

## Features

**Customers** can register and log in, browse the menu, add items to a basket, check out, and track the status of their latest order.

**Staff** can log in, add, edit and delete menu items, and move orders through each stage (confirmed, being prepared, in transit, delivered).

## How it's built

- **Object-oriented model:** `User` is extended by `Customer` and `Staff`, and `MenuItem` by `FoodItem` and `DrinkItem`.
- **Repository classes** (`UserRepository`, `MenuRepository`, `OrderReposirtory`) load and save data as JSON using the Gson library.
- **HashMaps** give fast lookup of users by email and menu items by ID.
- **Screens** were built with the NetBeans GUI builder.

## Running it

Open the folder as a project in NetBeans and click Run. Gson is included as `gson-2.11.0 (1).jar` in the project folder.

## Demo logins

| Role | Login | Password |
|---|---|---|
| Customer | sarah.campbell@example.com | password123 |
| Customer | liam.reid@example.com | password123 |
| Staff | a1001 | admin123 |

## What I'd improve next

- Hash passwords (for example with bcrypt) instead of storing them as plain text.
- Add JUnit tests for basket and order totals.
- Move from JSON files to a database.
