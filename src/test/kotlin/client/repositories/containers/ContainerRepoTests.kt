package client.repositories.containers

import client.repositories.containers.data.Image
import dsl.commands.base.Dockerfile
import kotlin.test.Test

class ContainerRepoTests {
    private val containerRepo = ContainerRepo()
    @Test
    fun `Should get all containers`() {
        containerRepo.getAll()
    }

    @Test
    fun `Should get container by id`() {
        containerRepo.getById("123")
    }

    @Test
    fun `Should get container by name`() {
        containerRepo.getByName("container")
    }


    @Test
    fun `Should create container`() {
        containerRepo.create("container")
    }

    @Test
    fun `Should create container with image from image name`() {
        containerRepo.create("container", "image")
    }

    @Test
    fun `Should create container with image from image object`() {
        val image: Image = Image("ubuntu")
        containerRepo.create("container", "123")
    }

    @Test
    fun `Should create container with image from image Dockerfile`() {
        val dockerfile: Dockerfile = Dockerfile { FROM { +"ubuntu" } }
        containerRepo.create("container", dockerfile)
    }

    @Test
    fun `Should start container`() {
        containerRepo.start("123")
    }

    @Test
    fun `Should stop container`() {
        containerRepo.stop("123")
    }

    @Test
    fun `Should delete container`() {
        containerRepo.delete("123")
    }
}