<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KBeer</title>
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <div class="container with-margin-top">
            <div class="row with-margin-top">
                <form action="/beer" method="post">
                    <div class="col cell"><input type="text" name="name" class="form-control" placeholder="Name"/></div>
                    <div class="col cell"><input type="text" name="description" class="form-control" placeholder="Description"/></div>
                    <div class="col cell"><input type="text" name="abv" class="form-control" placeholder="ABV"/></div>
                    <div class="col cell"><input type="hidden" name="action" value="add"></div>
                    <div class="col cell"><button type="submit" class="btn btn-warning">Add</button></div>
                </form>
                <div class="col cell">
                    <form action="/beer" method="post">
                        <input type="hidden" name="action" value="random">
                        <button type="submit" class="btn btn-warning">Add random</button>
                    </form>
                </div>
            </div>
        </div>
        <#if beers?has_content>
            <div class="container with-margin-top with-margin-bottom">
                <div class="row header">
                    <div class="col-2 cell"><b>Name</b></div>
                    <div class="col-7 cell"><b>Description</b></div>
                    <div class="col-1 cell"><b>ABV</b></div>
                    <div class="col-2 cell">&nbsp;</div>
                </div>
                <#list beers as beer>
                  <div class="row with-border-bottom">
                    <div class="col-2 cell">${beer.name}</div>
                    <div class="col-7 cell">${beer.description}</div>
                    <div class="col-1 cell">${beer.abv?string(",##0.0")}</div>
                    <div class="col-2 cell">
                        <form action="/beer" method="post">
                            <button type="submit" class="btn btn-danger">Delete</button>
                            <input type="hidden" name="action" value="delete">
                            <input class="btn btn-danger" type="hidden" name="id" value="${beer.id}" />
                        </form>
                    </div>
                  </div>
                </#list>
            </div>
        </#if>
    </body>
</html>
