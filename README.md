[![official JetBrains project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)


# Creating an HTTP API with Ktor

This repository is the code corresponding to the hands-on lab [Creating HTTP APIs with Ktor](https://play.kotlinlang.org/hands-on/Creating%20http%20apis%20with%20ktor/01_Introduction). 

To not complicate the code, for this tutorial we'll be using an in-memory storage (i.e. a mutable list of Customers) – in a real application, we would be storing this information in a database, so that it doesn't get lost after restarting our application. 

At this point, it is worth highlighting again that in this tutorial, we are also intentionally glancing over issues that could arise from e.g. multiple requests accessing the storage at the same time. In production, data structures and code that can be accessed from multiple requests / threads at the same time should account for these cases – something that is out of the scope of this hands-on.